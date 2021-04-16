
public class Main {
    public static void main(String[] args) {

        GeneradorDeBoletas gb = new GeneradorDeBoletas();
        gb.generarBoletas(10);

        Control c = new Control();
        c.promedioPorVendedor("Laura");
        //System.out.println((gb.generarBoletas(10)).toString());

    }
}
