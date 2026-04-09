/**
 * Clase que representa un artículo de mobiliario en el sistema WoodShops.
 * <p>
 * Extiende {@link Producto} añadiendo el tipo de artículo según la enumeración
 * {@link TipoArticulo}. Agrupa productos que no son tableros ni barnices,
 * como estanterías, mesas, sillas o armarios.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class Articulo extends Producto {

    /** Tipo de artículo (estantería, mesa, silla, armario, etc.). */
    private TipoArticulo tipoArticulo;

    /**
     * Constructor por defecto.
     */
    public Articulo() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param codigo        código único del producto
     * @param descripcion   descripción del artículo
     * @param proveedor     proveedor que suministra el artículo
     * @param tipoArticulo  tipo de artículo
     */
    public Articulo(String codigo, String descripcion, Proveedor proveedor, TipoArticulo tipoArticulo) {
        super(codigo, descripcion, proveedor);
        this.tipoArticulo = tipoArticulo;
    }

    /**
     * Devuelve el tipo de artículo.
     *
     * @return tipo de artículo
     */
    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    /**
     * Establece el tipo de artículo.
     *
     * @param tipoArticulo nuevo tipo de artículo
     */
    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    /**
     * Devuelve una representación en cadena del artículo.
     *
     * @return cadena con todos los atributos del artículo
     */
    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + getCodigo() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", proveedor=" + getProveedor() +
                ", tipoArticulo=" + tipoArticulo +
                '}';
    }
}
