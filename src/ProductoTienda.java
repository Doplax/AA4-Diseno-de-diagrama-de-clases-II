public class ProductoTienda {
    private Producto producto;
    private double precioVenta;
    private int stock;

    public ProductoTienda() {
    }

    public ProductoTienda(Producto producto, double precioVenta, int stock) {
        this.producto = producto;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductoTienda{" +
                "producto=" + producto +
                ", precioVenta=" + precioVenta +
                ", stock=" + stock +
                '}';
    }
}
