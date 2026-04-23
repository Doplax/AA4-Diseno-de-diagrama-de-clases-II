import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Representa un ticket o factura de una venta realizada en una {@link Tienda}.
 * <p>
 * Cada ticket tiene un número identificativo, la fecha de la venta, el cliente
 * en caso de ser un cliente registrado (o {@code null} para clientes anónimos)
 * y el detalle de la venta en forma de lista de {@link LineaTicket}.
 * </p>
 *
 * @author Pol Valle Montes
 * @version 1.0
 */
public class Ticket {

    /** Formato usado para imprimir fechas en el ticket. */
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /** Número identificativo del ticket. */
    private int numero;

    /** Fecha en la que se emite el ticket. */
    private LocalDate fecha;

    /** Cliente registrado asociado al ticket o {@code null} si es anónimo. */
    private Cliente cliente;

    /** Líneas de detalle del ticket. */
    private ArrayList<LineaTicket> lineas;

    /**
     * Constructor por defecto. Inicializa las líneas como lista vacía.
     */
    public Ticket() {
        this.lineas = new ArrayList<>();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param numero  número identificativo del ticket
     * @param fecha   fecha del ticket
     * @param cliente cliente registrado o {@code null} si es anónimo
     * @param lineas  líneas de detalle
     */
    public Ticket(int numero, LocalDate fecha, Cliente cliente, ArrayList<LineaTicket> lineas) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.lineas = lineas;
    }

    /**
     * Devuelve el número del ticket.
     *
     * @return número del ticket
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número del ticket.
     *
     * @param numero nuevo número
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve la fecha del ticket.
     *
     * @return fecha del ticket
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del ticket.
     *
     * @param fecha nueva fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve el cliente asociado al ticket.
     *
     * @return cliente registrado o {@code null} si es anónimo
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente del ticket.
     *
     * @param cliente cliente registrado o {@code null} si es anónimo
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve las líneas del ticket.
     *
     * @return lista de {@link LineaTicket}
     */
    public ArrayList<LineaTicket> getLineas() {
        return lineas;
    }

    /**
     * Establece las líneas del ticket.
     *
     * @param lineas nueva lista de líneas
     */
    public void setLineas(ArrayList<LineaTicket> lineas) {
        this.lineas = lineas;
    }

    /**
     * Devuelve el descuento aplicado al ticket según el tipo de cliente.
     *
     * @return descuento entre 0.0 y 1.0
     */
    public double getDescuento() {
        return (cliente == null) ? 0.0 : cliente.getDescuento();
    }

    /**
     * Calcula la suma de los subtotales de todas las líneas, sin descuentos.
     *
     * @return importe bruto del ticket
     */
    public double getSubtotal() {
        double total = 0.0;
        for (LineaTicket linea : lineas) {
            total += linea.getSubtotal();
        }
        return total;
    }

    /**
     * Calcula el importe total del ticket aplicando el descuento del cliente.
     *
     * @return importe total con descuento aplicado
     */
    public double getTotal() {
        return getSubtotal() * (1.0 - getDescuento());
    }

    /**
     * Devuelve el ticket completo formateado para mostrar por pantalla.
     *
     * @return cadena con número, fecha, cliente, detalle y total
     */
    public String imprimirTicket() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("TICKET Nº ").append(numero).append("\n");
        sb.append("Fecha: ").append(fecha.format(FORMATO_FECHA)).append("\n");
        if (cliente != null) {
            sb.append("Cliente: ").append(cliente.getNombre())
                    .append(" (").append(cliente.getNif()).append(") - ")
                    .append(cliente.getTipo()).append("\n");
        } else {
            sb.append("Cliente: Anónimo\n");
        }
        sb.append("----------------------------------------\n");
        for (LineaTicket linea : lineas) {
            sb.append(linea).append("\n");
        }
        sb.append("----------------------------------------\n");
        sb.append(String.format("Subtotal: %.2f%n", getSubtotal()));
        if (getDescuento() > 0.0) {
            sb.append(String.format("Descuento: %.0f%%%n", getDescuento() * 100));
        }
        sb.append(String.format("TOTAL: %.2f%n", getTotal()));
        sb.append("========================================");
        return sb.toString();
    }

    /**
     * Devuelve una línea de resumen del ticket.
     *
     * @return cadena con número, fecha, cliente, descuento y total
     */
    public String resumen() {
        String clienteStr = (cliente == null)
                ? "Anónimo"
                : cliente.getNombre() + " (" + cliente.getTipo() + ")";
        String descuentoStr = (getDescuento() > 0.0)
                ? String.format("%.0f%%", getDescuento() * 100)
                : "-";
        return String.format("Nº %d | %s | Cliente: %s | Desc: %s | Total: %.2f",
                numero, fecha.format(FORMATO_FECHA), clienteStr, descuentoStr, getTotal());
    }

    /**
     * Devuelve una representación en cadena del ticket.
     *
     * @return cadena con los atributos del ticket
     */
    @Override
    public String toString() {
        return "Ticket{numero=" + numero + ", fecha=" + fecha
                + ", cliente=" + cliente + ", lineas=" + lineas.size() + "}";
    }
}
