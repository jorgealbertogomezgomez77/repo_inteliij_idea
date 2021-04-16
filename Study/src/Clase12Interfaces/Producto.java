package Clase12Interfaces;

public class Producto implements ProductoInterfaz {
    String ID;
    double valor;

    @Override
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override

    public double valor() {
        return this.valor;
    }

    @Override
    public double multiplicarPor(int n) {
        return (double)valor * (double)n;
    }

    public double getValor() {
        return this.valor;
    }

    @Override
    public void imprime() {
        System.out.println(" ID: " + this.getID() + " Valor: " + this.getValor());
    }
}
