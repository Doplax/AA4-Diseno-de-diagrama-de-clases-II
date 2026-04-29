/**
 * Línea de detalle de un {@link Ticket}.
 * <p>
 * Cada línea almacena el registro {@link ProductoTienda} vendido, la cantidad
 * de unidades compradas y el precio unitario aplicado en el momento de la venta.
 * El precio se guarda como copia (snapshot) para que cambios posteriores en el
 * precio del producto en la tienda no alteren el importe de tickets ya emitidos.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.1
 */
public class LineaTicket {

    /** Registro producto-tienda vendido en esta línea. */
    private ProductoTienda productoTienda;

    /** Unidades vendidas del producto. */
    private int cantidad;

    /** Precio unitario aplicado en el momento de la venta. */
    private double precioUnitario;

    /**
     * Constructor por defecto.
     */
    public LineaTicket() {
    }

    /**
     * Construye una línea capturando el precio actual del producto en la tienda.
     *
     * @param productoTienda registro producto-tienda vendido
     * @param cantidad       unidades vendidas
     */
    public LineaTicket(ProductoTienda productoTienda, int cantidad) {
        this.productoTienda = productoTienda;
        this.cantidad = cantidad;
        this.precioUnitario = productoTienda.getPrecioVenta();
    }

    /**
     * Constructor con precio unitario explícito (útil para reconstruir tickets
     * históricos sin depender del precio actual del producto en la tienda).
     *
     * @param productoTienda registro producto-tienda vendido
     * @param cantidad       unidades vendidas
     * @param precioUnitario precio unitario aplicado en la venta
     */
    public LineaTicket(ProductoTienda productoTienda, int cantidad, double precioUnitario) {
        this.productoTienda = productoTienda;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
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
     * Devuelve el precio unitario aplicado en la línea.
     *
     * @return precio unitario congelado en el momento de la venta
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Establece el precio unitario aplicado en la línea.
     *
     * @param precioUnitario nuevo precio unitario
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Calcula el subtotal de la línea: precio unitario por cantidad.
     *
     * @return importe de la línea sin descuentos
     */
    public double getSubtotal() {
        return precioUnitario * cantidad;
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
                + "@ " + precioUnitario + " = " + getSubtotal();
    }
}
