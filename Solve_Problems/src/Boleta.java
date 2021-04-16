
public class Boleta {
    private String num_vendedor;
    private double importe;

    public Boleta() {

    }

    public Boleta(String num_vendedor, double importe) {
        this.num_vendedor = num_vendedor;
        this.importe = importe;
    }

    public String getNum_vendedor() {
        return num_vendedor;
    }

    public void setNum_vendedor(String num_vendedor) {
        this.num_vendedor = num_vendedor;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Boleta{" + "num_vendedor='" + num_vendedor + '\'' +
                ", importe=" + importe + '}';
    }
}
