/**
 * Clase que representa un proveedor de productos en el sistema WoodShops.
 * <p>
 * Cada proveedor se identifica por su NIF y nombre. Un mismo proveedor puede
 * suministrar varios productos.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.1
 */
public class Proveedor {

    /** NIF (Número de Identificación Fiscal) del proveedor. */
    private String nif;

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
     * @param nif    NIF del proveedor
     * @param nombre nombre del proveedor
     */
    public Proveedor(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    /**
     * Devuelve el NIF del proveedor.
     *
     * @return NIF del proveedor
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el NIF del proveedor.
     *
     * @param nif nuevo NIF del proveedor
     */
    public void setNif(String nif) {
        this.nif = nif;
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
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
