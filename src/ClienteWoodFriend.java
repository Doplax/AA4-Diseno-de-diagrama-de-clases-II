/**
 * Cliente registrado de tipo WoodFriend.
 * <p>
 * Los clientes WoodFriend son clientes asiduos a los cuales se les ofrecen
 * ofertas especiales. Se identifican por un código de socio que se les asigna
 * en el momento del alta.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class ClienteWoodFriend extends Cliente {

    /** Código de socio asignado al cliente. */
    private String codigoSocio;

    /**
     * Constructor por defecto.
     */
    public ClienteWoodFriend() {
        super();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nif         NIF del cliente
     * @param nombre      nombre del cliente
     * @param codigoSocio código de socio asignado
     */
    public ClienteWoodFriend(String nif, String nombre, String codigoSocio) {
        super(nif, nombre);
        this.codigoSocio = codigoSocio;
    }

    /**
     * Devuelve el código de socio del cliente.
     *
     * @return código de socio
     */
    public String getCodigoSocio() {
        return codigoSocio;
    }

    /**
     * Establece el código de socio del cliente.
     *
     * @param codigoSocio nuevo código de socio
     */
    public void setCodigoSocio(String codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    /**
     * Devuelve el tipo de cliente.
     *
     * @return la cadena {@code "WoodFriend"}
     */
    @Override
    public String getTipo() {
        return "WoodFriend";
    }
}
