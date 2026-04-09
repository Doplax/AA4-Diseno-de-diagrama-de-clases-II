/**
 * Clase que representa un proveedor de productos en el sistema WoodShops.
 * <p>
 * Cada proveedor se identifica por su NIF y nombre. Un mismo proveedor puede
 * suministrar varios productos.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class Proveedor {

    /** NIF (Número de Identificación Fiscal) del proveedor. */
    private String NIF;

    /** Nombre o razón social del proveedor. */
    private String nombre;

    /**
     * Constructor por defecto.
     */
    public Proveedor() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param NIF    NIF del proveedor
     * @param nombre nombre del proveedor
     */
    public Proveedor(String NIF, String nombre) {
        this.NIF = NIF;
        this.nombre = nombre;
    }

    /**
     * Devuelve el NIF del proveedor.
     *
     * @return NIF del proveedor
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Establece el NIF del proveedor.
     *
     * @param NIF nuevo NIF del proveedor
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * Devuelve el nombre del proveedor.
     *
     * @return nombre del proveedor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre nuevo nombre del proveedor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una representación en cadena del proveedor.
     *
     * @return cadena con el NIF y nombre del proveedor
     */
    @Override
    public String toString() {
        return "Proveedor{" +
                "NIF='" + NIF + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
