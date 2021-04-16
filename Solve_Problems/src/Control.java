
public class Control {

    public double promedioPorVendedor(String nombre) {
        Boleta bol = new Boleta();
        GeneradorDeBoletas gb = new GeneradorDeBoletas();
        gb.generarBoletas(10);
        double promedio = 0.0;
        if (bol.getNum_vendedor().compareToIgnoreCase(nombre) == 0) {
            double aux = 0;
            int cont = 0;
            aux += bol.getImporte();
            cont += 1;
            promedio = aux / cont;
        }
        return promedio;
    }
}
