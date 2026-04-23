/**
 * Clase abstracta que representa a un cliente registrado de WoodShops.
 * <p>
 * De todo cliente registrado se almacena el NIF y el nombre. Los clientes
 * no registrados son anónimos y no se modelan con esta clase (se tratan como
 * {@code null} en el {@link Ticket}).
 * </p>
 * <p>
 * Tiene dos subclases concretas: {@link ClienteProfesional} y
 * {@link ClienteWoodFriend}.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public abstract class Cliente {

    /** NIF del cliente. */
    private String nif;

    /** Nombre del cliente. */
    private String nombre;

    /**
     * Constructor por defecto.
     */
    public Cliente() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nif    NIF del cliente
     * @param nombre nombre del cliente
     */
    public Cliente(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    /**
     * Devuelve el NIF del cliente.
     *
     * @return NIF del cliente
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el NIF del cliente.
     *
     * @param nif nuevo NIF del cliente
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Devuelve el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el descuento que se aplica al cliente sobre el total de la venta.
     * <p>
     * Por defecto los clientes no tienen descuento. Las subclases que sí
     * ofrezcan descuento deben sobrescribir este método.
     * </p>
     *
     * @return porcentaje de descuento entre 0.0 y 1.0
     */
    public double getDescuento() {
        return 0.0;
    }

    /**
     * Devuelve una descripción textual del tipo de cliente.
     *
     * @return cadena con el tipo de cliente
     */
    public abstract String getTipo();

    /**
     * Devuelve una representación en cadena del cliente.
     *
     * @return cadena con NIF, nombre y tipo de cliente
     */
    @Override
    public String toString() {
        return getTipo() + "{nif='" + nif + "', nombre='" + nombre + "'}";
    }
}
