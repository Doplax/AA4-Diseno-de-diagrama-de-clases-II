/**
 * Cliente registrado de tipo profesional.
 * <p>
 * Los clientes profesionales disponen de un descuento específico que se
 * aplica sobre el total de todas sus ventas. El descuento es un porcentaje
 * representado entre 0.0 (sin descuento) y 1.0 (100 %).
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class ClienteProfesional extends Cliente {

    /** Porcentaje de descuento del cliente (entre 0.0 y 1.0). */
    private double descuento;

    /**
     * Constructor por defecto.
     */
    public ClienteProfesional() {
        super();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nif       NIF del cliente
     * @param nombre    nombre del cliente
     * @param descuento porcentaje de descuento entre 0.0 y 1.0
     */
    public ClienteProfesional(String nif, String nombre, double descuento) {
        super(nif, nombre);
        this.descuento = descuento;
    }

    /**
     * Devuelve el porcentaje de descuento aplicable a este cliente.
     *
     * @return descuento entre 0.0 y 1.0
     */
    @Override
    public double getDescuento() {
        return descuento;
    }

    /**
     * Establece el porcentaje de descuento aplicable a este cliente.
     *
     * @param descuento nuevo descuento entre 0.0 y 1.0
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Devuelve el tipo de cliente.
     *
     * @return la cadena {@code "Profesional"}
     */
    @Override
    public String getTipo() {
        return "Profesional";
    }

    /**
     * Devuelve el detalle extra del cliente para mostrar en los listados:
     * el descuento aplicable.
     *
     * @return cadena con el descuento del cliente
     */
    @Override
    public String getDetalleExtra() {
        return "Descuento: " + String.format("%.0f%%", descuento * 100);
    }
}
