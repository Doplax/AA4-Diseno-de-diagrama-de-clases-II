import java.util.ArrayList;

/**
 * Clase que representa la empresa WoodShops.
 * <p>
 * Actúa como contenedor central de todas las {@link Tienda tiendas} que forman
 * parte de la empresa y de los {@link Cliente clientes} registrados. Desde esta
 * clase se accede al conjunto de tiendas y clientes para realizar operaciones
 * de consulta y gestión.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.1
 */
public class WoodShops {

    /** Lista de tiendas que pertenecen a la empresa. */
    private ArrayList<Tienda> tiendas;

    /** Lista de clientes registrados en la empresa. */
    private ArrayList<Cliente> clientes;

    /**
     * Constructor por defecto. Inicializa las listas de tiendas y clientes vacías.
     */
    public WoodShops() {
        this.tiendas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param tiendas  lista de tiendas de la empresa
     * @param clientes lista de clientes registrados de la empresa
     */
    public WoodShops(ArrayList<Tienda> tiendas, ArrayList<Cliente> clientes) {
        this.tiendas = tiendas;
        this.clientes = clientes;
    }

    /**
     * Devuelve la lista de tiendas de la empresa.
     *
     * @return lista de {@link Tienda}
     */
    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    /**
     * Establece la lista de tiendas de la empresa.
     *
     * @param tiendas nueva lista de tiendas
     */
    public void setTiendas(ArrayList<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

    /**
     * Devuelve la lista de clientes registrados de la empresa.
     *
     * @return lista de {@link Cliente}
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Establece la lista de clientes registrados de la empresa.
     *
     * @param clientes nueva lista de clientes
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Devuelve una representación en cadena de la empresa.
     *
     * @return cadena con la lista de tiendas y clientes
     */
    @Override
    public String toString() {
        return "WoodShops{" +
                "tiendas=" + tiendas +
                ", clientes=" + clientes +
                '}';
    }
}
