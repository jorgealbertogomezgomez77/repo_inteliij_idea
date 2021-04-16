package Clase6estructurasdeControl;

public class Clase6estructurasdeControl {
    public static void main(String[] args) {
        int dinero = 3456;
        int resultado;
        resultado = (dinero / 500);
        if (resultado > 0) {
            dinero = dinero - (resultado * 500);
            System.out.println("Billetes de 500 = " + resultado);
        }
        resultado = (dinero / 100);
        if (resultado > 0) {
            dinero = dinero - (resultado * 100);
            System.out.println("Billetes de 100 = " + resultado);
        }
        resultado = (dinero / 50);
        if (resultado > 0) {
            dinero = dinero - (resultado * 50);
            System.out.println("Billetes de 50 = " + resultado);
        }
        resultado = (dinero / 20);
        if (resultado > 0) {
            dinero = dinero - (resultado * 20);
            System.out.println("Billetes de 20 = " + resultado);
        }
        resultado = (dinero / 10);
        if (resultado > 0) {
            dinero = dinero - (resultado * 10);
            System.out.println("Billetes de 10 = " + resultado);
        }
        resultado = (dinero / 5);
        if (resultado > 0) {
            dinero = dinero - (resultado * 5);
            System.out.println("Billetes de 5 = " + resultado);
        }
        System.out.println("Monedas igual a = " + dinero);
    }
}
