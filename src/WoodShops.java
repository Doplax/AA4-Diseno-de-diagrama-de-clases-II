import java.util.ArrayList;

/**
 * Clase que representa la empresa WoodShops.
 * <p>
 * Actúa como contenedor central de todas las {@link Tienda tiendas} que forman
 * parte de la empresa. Desde esta clase se accede al conjunto de tiendas para
 * realizar operaciones de consulta y gestión de inventario.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class WoodShops {

    /** Lista de tiendas que pertenecen a la empresa. */
    private ArrayList<Tienda> tiendas;

    /**
     * Constructor por defecto. Inicializa la lista de tiendas vacía.
     */
    public WoodShops() {
        this.tiendas = new ArrayList<>();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param tiendas lista de tiendas de la empresa
     */
    public WoodShops(ArrayList<Tienda> tiendas) {
        this.tiendas = tiendas;
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
     * Devuelve una representación en cadena de la empresa.
     *
     * @return cadena con la lista de tiendas
     */
    @Override
    public String toString() {
        return "WoodShops{" +
                "tiendas=" + tiendas +
                '}';
    }
}
