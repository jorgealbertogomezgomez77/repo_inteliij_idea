package Clase4dibujosgeometricos;

public class Ovalo {
    private int x;
    private int y;
    private int ancho;
    private int alto;

    public Ovalo() {

    }

    public Ovalo(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y =y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
}
