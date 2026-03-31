public class Proveedor {
    private String NIF;
    private String nombre;

    public Proveedor() {
    }

    public Proveedor(String NIF, String nombre) {
        this.NIF = NIF;
        this.nombre = nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "NIF='" + NIF + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
