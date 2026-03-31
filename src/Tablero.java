public class Tablero extends Producto {
    private double altura;
    private double anchura;
    private TipoTablero tipoTablero;

    public Tablero() {
    }

    public Tablero(String codigo, String descripcion, Proveedor proveedor, double altura, double anchura, TipoTablero tipoTablero) {
        super(codigo, descripcion, proveedor);
        this.altura = altura;
        this.anchura = anchura;
        this.tipoTablero = tipoTablero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAnchura() {
        return anchura;
    }

    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }

    public TipoTablero getTipoTablero() {
        return tipoTablero;
    }

    public void setTipoTablero(TipoTablero tipoTablero) {
        this.tipoTablero = tipoTablero;
    }

    @Override
    public String toString() {
        return "Tablero{" +
                "codigo='" + getCodigo() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", proveedor=" + getProveedor() +
                ", altura=" + altura +
                ", anchura=" + anchura +
                ", tipoTablero=" + tipoTablero +
                '}';
    }
}
