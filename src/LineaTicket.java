/**
 * Línea de detalle de un {@link Ticket}.
 * <p>
 * Cada línea almacena el registro {@link ProductoTienda} vendido (que contiene
 * el producto y su precio de venta en la tienda correspondiente) y la cantidad
 * de unidades compradas de ese producto.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class LineaTicket {

    /** Registro producto-tienda vendido en esta línea. */
    private ProductoTienda productoTienda;

    /** Unidades vendidas del producto. */
    private int cantidad;

    /**
     * Constructor por defecto.
     */
    public LineaTicket() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param productoTienda registro producto-tienda vendido
     * @param cantidad       unidades vendidas
     */
    public LineaTicket(ProductoTienda productoTienda, int cantidad) {
        this.productoTienda = productoTienda;
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el registro producto-tienda vendido.
     *
     * @return {@link ProductoTienda} de la línea
     */
    public ProductoTienda getProductoTienda() {
        return productoTienda;
    }

    /**
     * Establece el registro producto-tienda vendido.
     *
     * @param productoTienda nuevo registro producto-tienda
     */
    public void setProductoTienda(ProductoTienda productoTienda) {
        this.productoTienda = productoTienda;
    }

    /**
     * Devuelve la cantidad vendida.
     *
     * @return unidades vendidas
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad vendida.
     *
     * @param cantidad nuevas unidades vendidas
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal de la línea: precio de venta por cantidad.
     *
     * @return importe de la línea sin descuentos
     */
    public double getSubtotal() {
        return productoTienda.getPrecioVenta() * cantidad;
    }

    /**
     * Devuelve una representación en cadena de la línea.
     *
     * @return cadena con el producto, la cantidad y el subtotal
     */
    @Override
    public String toString() {
        return "  " + cantidad + " x " + productoTienda.getProducto().getDescripcion()
                + " (" + productoTienda.getProducto().getCodigo() + ") "
                + "@ " + productoTienda.getPrecioVenta() + " = " + getSubtotal();
    }
}
