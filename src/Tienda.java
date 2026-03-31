import java.util.ArrayList;

public class Tienda {
    private String nombre;
    private String ubicacion;
    private ArrayList<ProductoTienda> inventario;

    public Tienda() {
        this.inventario = new ArrayList<>();
    }

    public Tienda(String nombre, String ubicacion, ArrayList<ProductoTienda> inventario) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<ProductoTienda> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<ProductoTienda> inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", inventario=" + inventario +
                '}';
    }
}
