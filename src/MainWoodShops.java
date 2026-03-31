import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainWoodShops {

    public static WoodShops cargaDatosIniciales() {
        // 2 objetos Proveedor
        Proveedor prov1 = new Proveedor("11111111A", "Maderas del Norte");
        Proveedor prov2 = new Proveedor("22222222B", "Barnices ColorSur");

        // 3 objetos Producto (1 Tablero, 1 Barniz, 1 Articulo)
        Tablero tablero1 = new Tablero("T001", "Tablero de pino", prov1, 2.0, 1.5, TipoTablero.AGLOMERADO);
        Barniz barniz1 = new Barniz("B001", "Barniz brillante", prov2, 500, ColorBarniz.INCOLORO);
        Articulo articulo1 = new Articulo("A001", "Milla de comedor", prov1, TipoArticulo.MESA);

        // 2 objetos Tienda
        Tienda tienda1 = new Tienda("Tienda Norte", "Calle Mayor 1", new ArrayList<>());
        Tienda tienda2 = new Tienda("Tienda Sur", "Avenida Sol 45", new ArrayList<>());

        // Añadir los productos a los inventarios con precioVenta y stock distinto
        tienda1.getInventario().add(new ProductoTienda(tablero1, 25.50, 100));
        tienda1.getInventario().add(new ProductoTienda(barniz1, 10.99, 50));
        tienda1.getInventario().add(new ProductoTienda(articulo1, 120.00, 10));

        tienda2.getInventario().add(new ProductoTienda(tablero1, 26.00, 80));
        tienda2.getInventario().add(new ProductoTienda(barniz1, 11.50, 60));
        tienda2.getInventario().add(new ProductoTienda(articulo1, 115.00, 15));

        // Añadir las tiendas al objeto WoodShops
        WoodShops woodShops = new WoodShops();
        woodShops.getTiendas().add(tienda1);
        woodShops.getTiendas().add(tienda2);

        return woodShops;
    }

    public static void main(String[] args) {
        WoodShops empresa = cargaDatosIniciales();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ WOODSHOPS ===");
            System.out.println("1. Añadir nuevo producto a una tienda");
            System.out.println("2. Listar productos de una tienda por tipo");
            System.out.println("3. Mostrar stock por código de producto");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = -1;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.nextLine(); // Limpiar el buffer
                continue;
            }

            switch (opcion) {
                case 1:
                    anadirProducto(empresa, scanner);
                    break;
                case 2:
                    listarProductos(empresa, scanner);
                    break;
                case 3:
                    mostrarStock(empresa, scanner);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    private static void anadirProducto(WoodShops empresa, Scanner scanner) {
        int indiceTienda = seleccionarTienda(empresa, scanner);
        if (indiceTienda == -1) return;

        Tienda tiendaSeleccionada = empresa.getTiendas().get(indiceTienda);

        System.out.println("\n¿Qué tipo de producto quieres añadir?");
        System.out.println("1. Tablero\n2. Barniz\n3. Artículo");
        System.out.print("Elige una opción: ");
        
        int tipoProducto = -1;
        try {
            tipoProducto = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un número.");
            scanner.nextLine();
            return;
        }

        System.out.print("Introduce el código del producto: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduce la descripción: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Introduce el NIF del proveedor: ");
        String nifProv = scanner.nextLine();
        System.out.print("Introduce el nombre del proveedor: ");
        String nombreProv = scanner.nextLine();
        Proveedor proveedor = new Proveedor(nifProv, nombreProv);

        Producto nuevoProducto = null;

        try {
            if (tipoProducto == 1) { // Tablero
                System.out.print("Altura: ");
                double altura = scanner.nextDouble();
                System.out.print("Anchura: ");
                double anchura = scanner.nextDouble();
                System.out.println("Tipos de tablero: 1. AGLOMERADO | 2. CONTRACHAPADO | 3. MDF");
                int tipoIndex = scanner.nextInt();
                TipoTablero tipo = TipoTablero.values()[tipoIndex - 1];
                
                nuevoProducto = new Tablero(codigo, descripcion, proveedor, altura, anchura, tipo);
                
            } else if (tipoProducto == 2) { // Barniz
                System.out.print("Mililitros: ");
                int ml = scanner.nextInt();
                System.out.println("Colores: 1. INCOLORO | 2. CAOBA | 3. NOGAL");
                int colorIndex = scanner.nextInt();
                ColorBarniz color = ColorBarniz.values()[colorIndex - 1];
                
                nuevoProducto = new Barniz(codigo, descripcion, proveedor, ml, color);
                
            } else if (tipoProducto == 3) { // Artículo
                System.out.println("Tipos de artículo: 1. ESTANTERIA | 2. MESA | 3. SILLA | 4. ARMARIO");
                int tipoIndex = scanner.nextInt();
                TipoArticulo tipo = TipoArticulo.values()[tipoIndex - 1];
                
                nuevoProducto = new Articulo(codigo, descripcion, proveedor, tipo);
            } else {
                System.out.println("Tipo de producto no reconocido.");
                return;
            }

            System.out.print("Precio de venta general: ");
            double precio = scanner.nextDouble();
            System.out.print("Stock inicial: ");
            int stock = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            ProductoTienda pt = new ProductoTienda(nuevoProducto, precio, stock);
            tiendaSeleccionada.getInventario().add(pt);
            
            System.out.println("Producto añadido con éxito al inventario de " + tiendaSeleccionada.getNombre());

        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Datos introducidos no válidos. Operación cancelada.");
            scanner.nextLine(); // Limpiar el buffer si escaneó algo mal
        }
    }

    private static void listarProductos(WoodShops empresa, Scanner scanner) {
        int indiceTienda = seleccionarTienda(empresa, scanner);
        if (indiceTienda == -1) return;

        Tienda tiendaSeleccionada = empresa.getTiendas().get(indiceTienda);

        System.out.println("\n¿Qué tipo de producto quieres listar?");
        System.out.println("1. Tablero\n2. Barniz\n3. Artículo");
        System.out.print("Elige una opción: ");
        int tipoFiltro;
        try {
            tipoFiltro = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida.");
            scanner.nextLine();
            return;
        }

        System.out.println("\n--- Productos encontrados ---");
        boolean encontrado = false;
        for (ProductoTienda pt : tiendaSeleccionada.getInventario()) {
            if (tipoFiltro == 1 && pt.getProducto() instanceof Tablero) {
                System.out.println(pt);
                encontrado = true;
            } else if (tipoFiltro == 2 && pt.getProducto() instanceof Barniz) {
                System.out.println(pt);
                encontrado = true;
            } else if (tipoFiltro == 3 && pt.getProducto() instanceof Articulo) {
                System.out.println(pt);
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se han encontrado productos de ese tipo.");
        }
    }

    private static void mostrarStock(WoodShops empresa, Scanner scanner) {
        System.out.print("\nIntroduce el código del producto a buscar: ");
        String codigo = scanner.nextLine();

        boolean encontradoEnAlguna = false;
        System.out.println("--- Resultados de stock ---");
        
        for (Tienda t : empresa.getTiendas()) {
            for (ProductoTienda pt : t.getInventario()) {
                if (pt.getProducto().getCodigo().equalsIgnoreCase(codigo)) {
                    System.out.println("- " + t.getNombre() + ": " + pt.getStock() + " unidades (Precio: " + pt.getPrecioVenta() + ")");
                    encontradoEnAlguna = true;
                    // Suponemos que un código solo aparece una vez en cada tienda
                    break;
                }
            }
        }
        
        if (!encontradoEnAlguna) {
            System.out.println("El código introducido no existe en el sistema.");
        }
    }

    private static int seleccionarTienda(WoodShops empresa, Scanner scanner) {
        ArrayList<Tienda> tiendas = empresa.getTiendas();
        if (tiendas.isEmpty()) {
            System.out.println("No hay tiendas registradas.");
            return -1;
        }

        System.out.println("\n--- Selecciona una tienda ---");
        for (int i = 0; i < tiendas.size(); i++) {
            System.out.println((i + 1) + ". " + tiendas.get(i).getNombre());
        }
        System.out.print("Elige una opción: ");
        
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar
            if (opcion < 1 || opcion > tiendas.size()) {
                System.out.println("Opción fuera de rango.");
                return -1;
            }
            return opcion - 1;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
            return -1;
        }
    }
}