public class Articulo extends Producto {
    private TipoArticulo tipoArticulo;

    public Articulo() {
    }

    public Articulo(String codigo, String descripcion, Proveedor proveedor, TipoArticulo tipoArticulo) {
        super(codigo, descripcion, proveedor);
        this.tipoArticulo = tipoArticulo;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

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
