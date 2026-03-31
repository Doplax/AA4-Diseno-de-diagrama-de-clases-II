public class Barniz extends Producto {
    private int mililitros;
    private ColorBarniz colorBarniz;

    public Barniz() {
    }

    public Barniz(String codigo, String descripcion, Proveedor proveedor, int mililitros, ColorBarniz colorBarniz) {
        super(codigo, descripcion, proveedor);
        this.mililitros = mililitros;
        this.colorBarniz = colorBarniz;
    }

    public int getMililitros() {
        return mililitros;
    }

    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    public ColorBarniz getColorBarniz() {
        return colorBarniz;
    }

    public void setColorBarniz(ColorBarniz colorBarniz) {
        this.colorBarniz = colorBarniz;
    }

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
