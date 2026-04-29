import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal del sistema WoodShops.
 * <p>
 * Contiene el método {@link #main(String[])} que arranca la aplicación,
 * el método de carga de datos iniciales y los métodos que implementan las
 * opciones del menú interactivo: gestión de inventario (añadir productos,
 * listar por tipo, consultar stock), gestión de clientes (alta y listado)
 * y gestión de ventas (alta de ticket con impresión y resumen de tickets
 * de una tienda filtrando por fechas).
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.1
 */
public class MainWoodShops {

    /** Formato usado para leer y mostrar fechas por pantalla. */
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /** Contador usado para asignar números correlativos a los tickets. */
    private static int siguienteNumeroTicket = 1;

    /**
     * Carga un conjunto de datos de ejemplo en el sistema.
     * <p>
     * Crea proveedores, productos, tiendas con inventario y clientes de
     * los dos tipos registrados. También crea un ticket inicial de ejemplo
     * en la primera tienda.
     * </p>
     *
     * @return objeto {@link WoodShops} con los datos iniciales cargados
     */
    public static WoodShops cargaDatosIniciales() {
        Proveedor prov1 = new Proveedor("11111111A", "Maderas del Norte");
        Proveedor prov2 = new Proveedor("22222222B", "Barnices ColorSur");

        Tablero tablero1 = new Tablero("T001", "Tablero de pino", prov1, 2.0, 1.5, TipoTablero.AGLOMERADO);
        Barniz barniz1 = new Barniz("B001", "Barniz brillante", prov2, 500, ColorBarniz.INCOLORO);
        Articulo articulo1 = new Articulo("A001", "Mesa de comedor", prov1, TipoArticulo.MESA);

        Tienda tienda1 = new Tienda("Tienda Norte", "Calle Mayor 1", new ArrayList<>());
        Tienda tienda2 = new Tienda("Tienda Sur", "Avenida Sol 45", new ArrayList<>());

        ProductoTienda pt1Tablero = new ProductoTienda(tablero1, 25.50, 100);
        ProductoTienda pt1Barniz = new ProductoTienda(barniz1, 10.99, 50);
        ProductoTienda pt1Articulo = new ProductoTienda(articulo1, 120.00, 10);
        tienda1.getInventario().add(pt1Tablero);
        tienda1.getInventario().add(pt1Barniz);
        tienda1.getInventario().add(pt1Articulo);

        tienda2.getInventario().add(new ProductoTienda(tablero1, 26.00, 80));
        tienda2.getInventario().add(new ProductoTienda(barniz1, 11.50, 60));
        tienda2.getInventario().add(new ProductoTienda(articulo1, 115.00, 15));

        WoodShops woodShops = new WoodShops();
        woodShops.getTiendas().add(tienda1);
        woodShops.getTiendas().add(tienda2);

        // Clientes de ejemplo
        woodShops.getClientes().add(new ClienteProfesional("33333333C", "Carpintería Ramírez", 0.15));
        woodShops.getClientes().add(new ClienteWoodFriend("44444444D", "Ana López", "WF-0001"));
        woodShops.getClientes().add(new ClienteProfesional("55555555E", "Muebles Torres SL", 0.10));

        // Ticket inicial de ejemplo (con descuento del cliente profesional)
        ArrayList<LineaTicket> lineas = new ArrayList<>();
        lineas.add(new LineaTicket(pt1Tablero, 4));
        pt1Tablero.setStock(pt1Tablero.getStock() - 4);
        lineas.add(new LineaTicket(pt1Articulo, 1));
        pt1Articulo.setStock(pt1Articulo.getStock() - 1);
        Ticket ticketInicial = new Ticket(
                siguienteNumeroTicket++,
                LocalDate.now().minusDays(3),
                woodShops.getClientes().get(0),
                lineas);
        tienda1.getTickets().add(ticketInicial);

        return woodShops;
    }

    /**
     * Punto de entrada de la aplicación.
     * <p>
     * Carga los datos iniciales y muestra un menú interactivo con las opciones
     * disponibles hasta que el usuario decide salir.
     * </p>
     *
     * @param args argumentos de la línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        WoodShops empresa = cargaDatosIniciales();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ WOODSHOPS ===");
            System.out.println("1. Añadir nuevo producto a una tienda");
            System.out.println("2. Listar productos de una tienda por tipo");
            System.out.println("3. Mostrar stock por código de producto");
            System.out.println("4. Añadir nuevo cliente");
            System.out.println("5. Listar clientes");
            System.out.println("6. Añadir ticket de venta");
            System.out.println("7. Resumen de tickets de una tienda (por fechas)");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.nextLine();
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
                    anadirCliente(empresa, scanner);
                    break;
                case 5:
                    listarClientes(empresa);
                    break;
                case 6:
                    anadirTicket(empresa, scanner);
                    break;
                case 7:
                    resumenTickets(empresa, scanner);
                    break;
                case 8:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    /**
     * Permite al usuario añadir un nuevo producto al inventario de una tienda.
     *
     * @param empresa objeto {@link WoodShops} con las tiendas disponibles
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     */
    private static void anadirProducto(WoodShops empresa, Scanner scanner) {
        int indiceTienda = seleccionarTienda(empresa, scanner);
        if (indiceTienda == -1) return;

        Tienda tiendaSeleccionada = empresa.getTiendas().get(indiceTienda);

        System.out.println("\n¿Qué tipo de producto quieres añadir?");
        System.out.println("1. Tablero\n2. Barniz\n3. Artículo");
        System.out.print("Elige una opción: ");

        int tipoProducto;
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
            if (tipoProducto == 1) {
                System.out.print("Altura: ");
                double altura = scanner.nextDouble();
                System.out.print("Anchura: ");
                double anchura = scanner.nextDouble();
                TipoTablero tipo = leerEnum(scanner, "Tipo de tablero", TipoTablero.values());
                if (tipo == null) return;

                nuevoProducto = new Tablero(codigo, descripcion, proveedor, altura, anchura, tipo);

            } else if (tipoProducto == 2) {
                System.out.print("Mililitros: ");
                int ml = scanner.nextInt();
                ColorBarniz color = leerEnum(scanner, "Color del barniz", ColorBarniz.values());
                if (color == null) return;

                nuevoProducto = new Barniz(codigo, descripcion, proveedor, ml, color);

            } else if (tipoProducto == 3) {
                TipoArticulo tipo = leerEnum(scanner, "Tipo de artículo", TipoArticulo.values());
                if (tipo == null) return;

                nuevoProducto = new Articulo(codigo, descripcion, proveedor, tipo);
            } else {
                System.out.println("Tipo de producto no reconocido.");
                return;
            }

            System.out.print("Precio de venta general: ");
            double precio = scanner.nextDouble();
            System.out.print("Stock inicial: ");
            int stock = scanner.nextInt();
            scanner.nextLine();

            if (existeCodigoEnTienda(tiendaSeleccionada, codigo)) {
                System.out.println("Ya existe un producto con código '" + codigo
                        + "' en " + tiendaSeleccionada.getNombre() + ". Operación cancelada.");
                return;
            }

            ProductoTienda pt = new ProductoTienda(nuevoProducto, precio, stock);
            tiendaSeleccionada.getInventario().add(pt);

            System.out.println("Producto añadido con éxito al inventario de " + tiendaSeleccionada.getNombre());

        } catch (InputMismatchException e) {
            System.out.println("Datos introducidos no válidos. Operación cancelada.");
            scanner.nextLine();
        }
    }

    /**
     * Solicita por consola un valor de un tipo enumerado, mostrando el menú de
     * opciones de forma dinámica a partir de los valores del enum y validando
     * que la selección esté dentro de rango.
     *
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     * @param titulo  título a mostrar antes de las opciones
     * @param valores valores posibles del enum
     * @param <E>     tipo enumerado
     * @return valor seleccionado, o {@code null} si la entrada no es válida
     */
    private static <E extends Enum<E>> E leerEnum(Scanner scanner, String titulo, E[] valores) {
        System.out.println(titulo + ":");
        for (int i = 0; i < valores.length; i++) {
            System.out.println("  " + (i + 1) + ". " + valores[i]);
        }
        System.out.print("Elige una opción: ");
        try {
            int idx = scanner.nextInt();
            scanner.nextLine();
            if (idx < 1 || idx > valores.length) {
                System.out.println("Opción fuera de rango.");
                return null;
            }
            return valores[idx - 1];
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
            return null;
        }
    }

    /**
     * Indica si la tienda dada ya contiene un producto con el código indicado.
     *
     * @param tienda tienda a inspeccionar
     * @param codigo código de producto a buscar
     * @return {@code true} si ya existe un producto con ese código
     */
    private static boolean existeCodigoEnTienda(Tienda tienda, String codigo) {
        for (ProductoTienda pt : tienda.getInventario()) {
            if (pt.getProducto().getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Indica si la empresa ya tiene un cliente registrado con el NIF indicado.
     *
     * @param empresa empresa cuyos clientes se inspeccionan
     * @param nif     NIF a buscar
     * @return {@code true} si ya existe un cliente con ese NIF
     */
    private static boolean existeNifCliente(WoodShops empresa, String nif) {
        for (Cliente c : empresa.getClientes()) {
            if (c.getNif() != null && c.getNif().equalsIgnoreCase(nif)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lista los productos de una tienda filtrando por tipo.
     *
     * @param empresa objeto {@link WoodShops} con las tiendas disponibles
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     */
    private static void listarProductos(WoodShops empresa, Scanner scanner) {
        int indiceTienda = seleccionarTienda(empresa, scanner);
        if (indiceTienda == -1) return;

        Tienda tiendaSeleccionada = empresa.getTiendas().get(indiceTienda);

        String[] categorias = { "Tablero", "Barniz", "Articulo" };
        System.out.println("\n¿Qué tipo de producto quieres listar?");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i]);
        }
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
        if (tipoFiltro < 1 || tipoFiltro > categorias.length) {
            System.out.println("Opción fuera de rango.");
            return;
        }
        String categoriaBuscada = categorias[tipoFiltro - 1];

        System.out.println("\n--- Productos encontrados ---");
        boolean encontrado = false;
        for (ProductoTienda pt : tiendaSeleccionada.getInventario()) {
            if (pt.getProducto().getCategoria().equalsIgnoreCase(categoriaBuscada)) {
                System.out.println(pt);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se han encontrado productos de ese tipo.");
        }
    }

    /**
     * Muestra el stock de un producto en todas las tiendas en las que esté disponible.
     *
     * @param empresa objeto {@link WoodShops} con las tiendas disponibles
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     */
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
                    break;
                }
            }
        }

        if (!encontradoEnAlguna) {
            System.out.println("El código introducido no existe en el sistema.");
        }
    }

    /**
     * Añade un nuevo cliente registrado (Profesional o WoodFriend) al sistema.
     *
     * @param empresa objeto {@link WoodShops} con la lista global de clientes
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     */
    private static void anadirCliente(WoodShops empresa, Scanner scanner) {
        System.out.println("\n¿Qué tipo de cliente quieres añadir?");
        System.out.println("1. Profesional\n2. WoodFriend");
        System.out.print("Elige una opción: ");
        int tipo;
        try {
            tipo = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Opción inválida.");
            scanner.nextLine();
            return;
        }

        System.out.print("NIF: ");
        String nif = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        if (existeNifCliente(empresa, nif)) {
            System.out.println("Ya existe un cliente registrado con NIF '" + nif + "'. Operación cancelada.");
            return;
        }

        try {
            if (tipo == 1) {
                System.out.print("Descuento (ej. 0.15 para 15%): ");
                double descuento = scanner.nextDouble();
                scanner.nextLine();
                if (descuento < 0.0 || descuento > 1.0) {
                    System.out.println("Descuento fuera de rango [0.0 - 1.0].");
                    return;
                }
                empresa.getClientes().add(new ClienteProfesional(nif, nombre, descuento));
                System.out.println("Cliente profesional añadido con éxito.");
            } else if (tipo == 2) {
                System.out.print("Código de socio: ");
                String codigo = scanner.nextLine();
                empresa.getClientes().add(new ClienteWoodFriend(nif, nombre, codigo));
                System.out.println("Cliente WoodFriend añadido con éxito.");
            } else {
                System.out.println("Tipo de cliente no reconocido.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Datos inválidos. Operación cancelada.");
            scanner.nextLine();
        }
    }

    /**
     * Muestra por pantalla el listado de todos los clientes registrados con su tipo.
     *
     * @param empresa objeto {@link WoodShops} con la lista global de clientes
     */
    private static void listarClientes(WoodShops empresa) {
        ArrayList<Cliente> clientes = empresa.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("\nNo hay clientes registrados.");
            return;
        }
        System.out.println("\n--- Clientes registrados ---");
        for (Cliente c : clientes) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(c.getTipo()).append("] ")
                    .append(c.getNombre()).append(" - NIF: ").append(c.getNif());
            String extra = c.getDetalleExtra();
            if (extra != null && !extra.isEmpty()) {
                sb.append(" - ").append(extra);
            }
            System.out.println(sb);
        }
    }

    /**
     * Añade un ticket de venta a una tienda.
     * <p>
     * Solicita tienda, cliente (opcional) y líneas de detalle, crea el ticket
     * con fecha actual, lo almacena en la tienda y lo muestra completo.
     * </p>
     *
     * @param empresa objeto {@link WoodShops}
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     */
    private static void anadirTicket(WoodShops empresa, Scanner scanner) {
        int indiceTienda = seleccionarTienda(empresa, scanner);
        if (indiceTienda == -1) return;

        Tienda tienda = empresa.getTiendas().get(indiceTienda);

        if (tienda.getInventario().isEmpty()) {
            System.out.println("La tienda no tiene inventario. No se puede crear el ticket.");
            return;
        }

        Cliente cliente = seleccionarCliente(empresa, scanner);

        ArrayList<LineaTicket> lineas = new ArrayList<>();
        boolean anadirMas = true;
        while (anadirMas) {
            System.out.println("\n--- Inventario de " + tienda.getNombre() + " ---");
            for (int i = 0; i < tienda.getInventario().size(); i++) {
                ProductoTienda pt = tienda.getInventario().get(i);
                System.out.println((i + 1) + ". " + pt.getProducto().getCodigo()
                        + " - " + pt.getProducto().getDescripcion()
                        + " | Precio: " + pt.getPrecioVenta()
                        + " | Stock: " + pt.getStock());
            }
            System.out.print("Selecciona producto (0 para terminar): ");
            int sel;
            try {
                sel = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
                continue;
            }
            if (sel == 0) {
                anadirMas = false;
                continue;
            }
            if (sel < 1 || sel > tienda.getInventario().size()) {
                System.out.println("Opción fuera de rango.");
                continue;
            }
            ProductoTienda pt = tienda.getInventario().get(sel - 1);
            System.out.print("Cantidad: ");
            int cantidad;
            try {
                cantidad = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
                continue;
            }
            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
                continue;
            }
            if (cantidad > pt.getStock()) {
                System.out.println("Stock insuficiente. Disponible: " + pt.getStock());
                continue;
            }
            lineas.add(new LineaTicket(pt, cantidad));
            pt.setStock(pt.getStock() - cantidad);
            System.out.println("Línea añadida.");
        }

        if (lineas.isEmpty()) {
            System.out.println("Ticket vacío. Operación cancelada.");
            return;
        }

        Ticket ticket = new Ticket(siguienteNumeroTicket++, LocalDate.now(), cliente, lineas);
        tienda.getTickets().add(ticket);

        System.out.println("\n" + ticket.imprimirTicket());
    }

    /**
     * Muestra un resumen de los tickets emitidos por una tienda dentro de un rango
     * de fechas (ambos extremos inclusive).
     *
     * @param empresa objeto {@link WoodShops}
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     */
    private static void resumenTickets(WoodShops empresa, Scanner scanner) {
        int indiceTienda = seleccionarTienda(empresa, scanner);
        if (indiceTienda == -1) return;

        Tienda tienda = empresa.getTiendas().get(indiceTienda);

        System.out.print("Fecha inicio (dd/MM/yyyy): ");
        LocalDate inicio = leerFecha(scanner);
        if (inicio == null) return;
        System.out.print("Fecha fin (dd/MM/yyyy): ");
        LocalDate fin = leerFecha(scanner);
        if (fin == null) return;

        if (fin.isBefore(inicio)) {
            System.out.println("La fecha fin no puede ser anterior a la fecha inicio.");
            return;
        }

        System.out.println("\n--- Tickets de " + tienda.getNombre() + " entre "
                + inicio.format(FORMATO_FECHA) + " y " + fin.format(FORMATO_FECHA) + " ---");
        boolean hay = false;
        for (Ticket t : tienda.getTickets()) {
            LocalDate f = t.getFecha();
            if (!f.isBefore(inicio) && !f.isAfter(fin)) {
                System.out.println(t.resumen());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay tickets en ese rango de fechas.");
        }
    }

    /**
     * Lee una fecha por consola en formato {@code dd/MM/yyyy}.
     *
     * @param scanner objeto {@link Scanner} para leer la entrada
     * @return la fecha introducida, o {@code null} si el formato no es válido
     */
    private static LocalDate leerFecha(Scanner scanner) {
        String entrada = scanner.nextLine();
        try {
            return LocalDate.parse(entrada, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Usa el formato dd/MM/yyyy.");
            return null;
        }
    }

    /**
     * Permite al usuario elegir un cliente registrado (o indicar que es anónimo).
     *
     * @param empresa objeto {@link WoodShops} con la lista de clientes
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     * @return el cliente seleccionado, o {@code null} si la venta es anónima
     */
    private static Cliente seleccionarCliente(WoodShops empresa, Scanner scanner) {
        ArrayList<Cliente> clientes = empresa.getClientes();
        System.out.println("\n--- Cliente del ticket ---");
        System.out.println("0. Anónimo (sin registrar)");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println((i + 1) + ". [" + c.getTipo() + "] " + c.getNombre() + " - " + c.getNif());
        }
        System.out.print("Elige una opción: ");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 0) return null;
            if (opcion < 1 || opcion > clientes.size()) {
                System.out.println("Opción fuera de rango. Se tomará como cliente anónimo.");
                return null;
            }
            return clientes.get(opcion - 1);
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Entrada inválida. Se tomará como cliente anónimo.");
            return null;
        }
    }

    /**
     * Muestra por consola la lista de tiendas disponibles y devuelve el índice
     * de la tienda seleccionada por el usuario.
     *
     * @param empresa objeto {@link WoodShops} con las tiendas disponibles
     * @param scanner objeto {@link Scanner} para leer la entrada del usuario
     * @return índice (base 0) de la tienda seleccionada, o {@code -1} si la
     *         selección no es válida o no hay tiendas registradas
     */
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
            scanner.nextLine();
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
