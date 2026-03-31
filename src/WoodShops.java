import java.util.ArrayList;

public class WoodShops {
    private ArrayList<Tienda> tiendas;

    public WoodShops() {
        this.tiendas = new ArrayList<>();
    }

    public WoodShops(ArrayList<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(ArrayList<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

    @Override
    public String toString() {
        return "WoodShops{" +
                "tiendas=" + tiendas +
                '}';
    }
}
