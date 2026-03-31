public abstract class Producto {
    private String codigo;
    private String descripcion;
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(String codigo, String descripcion, Proveedor proveedor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", proveedor=" + proveedor +
                '}';
    }
}
