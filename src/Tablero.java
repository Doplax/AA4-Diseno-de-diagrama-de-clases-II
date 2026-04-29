/**
 * Clase que representa un tablero de madera en el sistema WoodShops.
 * <p>
 * Extiende {@link Producto} añadiendo las dimensiones del tablero (altura y anchura
 * en metros) y su tipo de material según la enumeración {@link TipoTablero}.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class Tablero extends Producto {

    /** Altura del tablero en metros. */
    private double altura;

    /** Anchura del tablero en metros. */
    private double anchura;

    /** Tipo de material del tablero. */
    private TipoTablero tipoTablero;

    /**
     * Constructor por defecto.
     */
    public Tablero() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param codigo       código único del producto
     * @param descripcion  descripción del tablero
     * @param proveedor    proveedor que suministra el tablero
     * @param altura       altura del tablero en metros
     * @param anchura      anchura del tablero en metros
     * @param tipoTablero  tipo de material del tablero
     */
    public Tablero(String codigo, String descripcion, Proveedor proveedor,
                   double altura, double anchura, TipoTablero tipoTablero) {
        super(codigo, descripcion, proveedor);
        this.altura = altura;
        this.anchura = anchura;
        this.tipoTablero = tipoTablero;
    }

    /**
     * Devuelve la altura del tablero.
     *
     * @return altura en metros
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Establece la altura del tablero.
     *
     * @param altura nueva altura en metros
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Devuelve la anchura del tablero.
     *
     * @return anchura en metros
     */
    public double getAnchura() {
        return anchura;
    }

    /**
     * Establece la anchura del tablero.
     *
     * @param anchura nueva anchura en metros
     */
    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }

    /**
     * Devuelve el tipo de material del tablero.
     *
     * @return tipo de tablero
     */
    public TipoTablero getTipoTablero() {
        return tipoTablero;
    }

    /**
     * Establece el tipo de material del tablero.
     *
     * @param tipoTablero nuevo tipo de tablero
     */
    public void setTipoTablero(TipoTablero tipoTablero) {
        this.tipoTablero = tipoTablero;
    }

    /**
     * Devuelve la categoría del producto.
     *
     * @return la cadena {@code "Tablero"}
     */
    @Override
    public String getCategoria() {
        return "Tablero";
    }

    /**
     * Devuelve una representación en cadena del tablero.
     *
     * @return cadena con todos los atributos del tablero
     */
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
