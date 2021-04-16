
import java.util.ArrayList;
import java.util.Random;

public class GeneradorDeBoletas {

    public ArrayList<Boleta> generarBoletas(int boletas) {
        ArrayList<Boleta> array_boletas = new ArrayList<Boleta>();
        for (int i = 0; i < boletas; i++) {
            Boleta b = new Boleta(this.generarVendedor(), this.generarImporte());
            b.toString();
            array_boletas.add(b);
        }
        return array_boletas;
    }

    private double generarImporte() {
        Random r = new Random();
        return r.nextDouble() * 250;
    }

    private String generarVendedor() {
        String vendedores = " ";
        Random r = new Random();
        String[] v = {"Laura", "Alberto", "Beatriz"};
        vendedores += (v[r.nextInt(v.length)]);
        return vendedores;
    }
}
