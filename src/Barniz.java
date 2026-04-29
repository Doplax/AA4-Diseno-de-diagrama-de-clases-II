/**
 * Clase que representa un barniz en el sistema WoodShops.
 * <p>
 * Extiende {@link Producto} añadiendo la cantidad en mililitros y el color
 * del barniz según la enumeración {@link ColorBarniz}.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class Barniz extends Producto {

    /** Cantidad de barniz en mililitros. */
    private int mililitros;

    /** Color o tono del barniz. */
    private ColorBarniz colorBarniz;

    /**
     * Constructor por defecto.
     */
    public Barniz() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param codigo       código único del producto
     * @param descripcion  descripción del barniz
     * @param proveedor    proveedor que suministra el barniz
     * @param mililitros   cantidad de barniz en mililitros
     * @param colorBarniz  color del barniz
     */
    public Barniz(String codigo, String descripcion, Proveedor proveedor,
                  int mililitros, ColorBarniz colorBarniz) {
        super(codigo, descripcion, proveedor);
        this.mililitros = mililitros;
        this.colorBarniz = colorBarniz;
    }

    /**
     * Devuelve la cantidad de barniz en mililitros.
     *
     * @return mililitros del envase
     */
    public int getMililitros() {
        return mililitros;
    }

    /**
     * Establece la cantidad de barniz en mililitros.
     *
     * @param mililitros nueva cantidad en mililitros
     */
    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    /**
     * Devuelve el color del barniz.
     *
     * @return color del barniz
     */
    public ColorBarniz getColorBarniz() {
        return colorBarniz;
    }

    /**
     * Establece el color del barniz.
     *
     * @param colorBarniz nuevo color del barniz
     */
    public void setColorBarniz(ColorBarniz colorBarniz) {
        this.colorBarniz = colorBarniz;
    }

    /**
     * Devuelve la categoría del producto.
     *
     * @return la cadena {@code "Barniz"}
     */
    @Override
    public String getCategoria() {
        return "Barniz";
    }

    /**
     * Devuelve una representación en cadena del barniz.
     *
     * @return cadena con todos los atributos del barniz
     */
    @Override
    public String toString() {
        return "Barniz{" +
                "codigo='" + getCodigo() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", proveedor=" + getProveedor() +
                ", mililitros=" + mililitros +
                ", colorBarniz=" + colorBarniz +
                '}';
    }
}
