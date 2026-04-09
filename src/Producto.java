/**
 * Clase abstracta que representa un producto genérico del sistema WoodShops.
 * <p>
 * Sirve como base para los tres tipos de productos: {@link Tablero}, {@link Barniz}
 * y {@link Articulo}. Almacena los atributos comunes a todos los productos.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public abstract class Producto {

    /** Código único que identifica el producto. */
    private String codigo;

    /** Descripción textual del producto. */
    private String descripcion;

    /** Proveedor que suministra este producto. */
    private Proveedor proveedor;

    /**
     * Constructor por defecto.
     */
    public Producto() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param codigo      código único del producto
     * @param descripcion descripción del producto
     * @param proveedor   proveedor que suministra el producto
     */
    public Producto(String codigo, String descripcion, Proveedor proveedor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    /**
     * Devuelve el código del producto.
     *
     * @return código del producto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del producto.
     *
     * @param codigo nuevo código del producto
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve la descripción del producto.
     *
     * @return descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion nueva descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el proveedor del producto.
     *
     * @return proveedor del producto
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Establece el proveedor del producto.
     *
     * @param proveedor nuevo proveedor del producto
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * Devuelve una representación en cadena del producto.
     *
     * @return cadena con los atributos del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", proveedor=" + proveedor +
                '}';
    }
}
