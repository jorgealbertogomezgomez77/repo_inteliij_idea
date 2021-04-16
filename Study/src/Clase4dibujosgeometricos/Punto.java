package Clase4dibujosgeometricos;

public class Punto {
    private int px;
    private int py;

    public Punto() {

    }

    public Punto(int x, int y){
        this.px = x;
        this.py = y;
    }

    public int getPx() {
        return this.px;
    }

    public int getPy() {
        return this.py;
    }

    public void setPx(int x) {
        this.px = x;
    }

    public void setPy(int y) {
        this.py = y;
    }
}
