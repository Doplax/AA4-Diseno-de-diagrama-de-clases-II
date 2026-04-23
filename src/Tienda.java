import java.util.ArrayList;

/**
 * Clase que representa una tienda dentro de la empresa WoodShops.
 * <p>
 * Cada tienda dispone de su propio inventario, almacenado como una lista
 * de objetos {@link ProductoTienda}, y de su propia lista de {@link Ticket tickets}
 * de venta. Un mismo producto puede estar en varias tiendas con precio y stock
 * distintos.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.1
 */
public class Tienda {

    /** Nombre de la tienda. */
    private String nombre;

    /** Dirección o ubicación física de la tienda. */
    private String ubicacion;

    /** Inventario de productos disponibles en esta tienda. */
    private ArrayList<ProductoTienda> inventario;

    /** Tickets de venta emitidos por esta tienda. */
    private ArrayList<Ticket> tickets;

    /**
     * Constructor por defecto. Inicializa inventario y tickets como listas vacías.
     */
    public Tienda() {
        this.inventario = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    /**
     * Constructor con nombre, ubicación e inventario. La lista de tickets se
     * inicializa vacía.
     *
     * @param nombre     nombre de la tienda
     * @param ubicacion  dirección o ubicación de la tienda
     * @param inventario lista de productos con su precio y stock en esta tienda
     */
    public Tienda(String nombre, String ubicacion, ArrayList<ProductoTienda> inventario) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.inventario = inventario;
        this.tickets = new ArrayList<>();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nombre     nombre de la tienda
     * @param ubicacion  dirección o ubicación de la tienda
     * @param inventario lista de productos con su precio y stock en esta tienda
     * @param tickets    lista de tickets de la tienda
     */
    public Tienda(String nombre, String ubicacion, ArrayList<ProductoTienda> inventario,
                  ArrayList<Ticket> tickets) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.inventario = inventario;
        this.tickets = tickets;
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
     * Devuelve la lista de tickets de la tienda.
     *
     * @return lista de {@link Ticket}
     */
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Establece la lista de tickets de la tienda.
     *
     * @param tickets nueva lista de tickets
     */
    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * Devuelve una representación en cadena de la tienda.
     *
     * @return cadena con el nombre, ubicación, inventario y número de tickets
     */
    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", inventario=" + inventario +
                ", tickets=" + tickets.size() +
                '}';
    }
}
