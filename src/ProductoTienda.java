/**
 * Clase que representa la relación entre un producto y una tienda concreta.
 * <p>
 * Un mismo {@link Producto} puede existir en varias tiendas con distinto precio
 * de venta y stock, por lo que esta clase actúa como contenedor de esos valores
 * específicos de cada tienda.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class ProductoTienda {

    /** Producto almacenado en la tienda. */
    private Producto producto;

    /** Precio de venta del producto en esta tienda. */
    private double precioVenta;

    /** Unidades disponibles en el inventario de esta tienda. */
    private int stock;

    /**
     * Constructor por defecto.
     */
    public ProductoTienda() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param producto    producto al que pertenece este registro
     * @param precioVenta precio de venta en esta tienda
     * @param stock       unidades en stock en esta tienda
     */
    public ProductoTienda(Producto producto, double precioVenta, int stock) {
        this.producto = producto;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    /**
     * Devuelve el producto asociado.
     *
     * @return producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado.
     *
     * @param producto nuevo producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Devuelve el precio de venta del producto en esta tienda.
     *
     * @return precio de venta
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Establece el precio de venta del producto en esta tienda.
     *
     * @param precioVenta nuevo precio de venta
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Devuelve el stock disponible del producto en esta tienda.
     *
     * @return unidades en stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock disponible del producto en esta tienda.
     *
     * @param stock nuevas unidades en stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve una representación en cadena del registro producto-tienda.
     *
     * @return cadena con el producto, precio de venta y stock
     */
    @Override
    public String toString() {
        return "ProductoTienda{" +
                "producto=" + producto +
                ", precioVenta=" + precioVenta +
                ", stock=" + stock +
                '}';
    }
}
