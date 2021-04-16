package Clase4dibujosgeometricos;

public class Recta {
    private Punto pinicial;
    private Punto pfinal;

    public Recta() {

    }

    public Recta(Punto p1, Punto p2) {
        this.pinicial = p1;
        this.pfinal = p2;
    }

    public Punto getPinicial() {
        return pinicial;
    }

    public void setPinicial(Punto pinicial) {
        this.pinicial = pinicial;
    }

    public Punto getPfinal() {
        return pfinal;
    }

    public void setPfinal(Punto pfinal) {
        this.pfinal = pfinal;
    }
}
