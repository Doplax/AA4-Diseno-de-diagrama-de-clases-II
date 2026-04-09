import java.util.ArrayList;

/**
 * Clase que representa una tienda dentro de la empresa WoodShops.
 * <p>
 * Cada tienda dispone de su propio inventario, almacenado como una lista
 * de objetos {@link ProductoTienda}. Un mismo producto puede estar en varias
 * tiendas con precio y stock distintos.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class Tienda {

    /** Nombre de la tienda. */
    private String nombre;

    /** Dirección o ubicación física de la tienda. */
    private String ubicacion;

    /** Inventario de productos disponibles en esta tienda. */
    private ArrayList<ProductoTienda> inventario;

    /**
     * Constructor por defecto. Inicializa el inventario como una lista vacía.
     */
    public Tienda() {
        this.inventario = new ArrayList<>();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nombre     nombre de la tienda
     * @param ubicacion  dirección o ubicación de la tienda
     * @param inventario lista de productos con su precio y stock en esta tienda
     */
    public Tienda(String nombre, String ubicacion, ArrayList<ProductoTienda> inventario) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.inventario = inventario;
    }

    /**
     * Devuelve el nombre de la tienda.
     *
     * @return nombre de la tienda
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la tienda.
     *
     * @param nombre nuevo nombre de la tienda
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la ubicación de la tienda.
     *
     * @return ubicación de la tienda
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la tienda.
     *
     * @param ubicacion nueva ubicación de la tienda
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Devuelve el inventario de la tienda.
     *
     * @return lista de {@link ProductoTienda} que componen el inventario
     */
    public ArrayList<ProductoTienda> getInventario() {
        return inventario;
    }

    /**
     * Establece el inventario de la tienda.
     *
     * @param inventario nueva lista de productos de la tienda
     */
    public void setInventario(ArrayList<ProductoTienda> inventario) {
        this.inventario = inventario;
    }

    /**
     * Devuelve una representación en cadena de la tienda.
     *
     * @return cadena con el nombre, ubicación e inventario de la tienda
     */
    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", inventario=" + inventario +
                '}';
    }
}
