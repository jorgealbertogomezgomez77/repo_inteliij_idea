package Clase4dibujosgeometricos;

import java.awt.*;

public class Poligono {
    private int npuntos;
    private int[] coordenadasX;
    private int[] coordenadasY;

    public Poligono() {

    }

    public Poligono(int npuntos, int[] coordenadasX, int[] coordenadasY) {
        this.npuntos = npuntos;
        this.coordenadasX = coordenadasX;
        this.coordenadasY = coordenadasY;
    }

    public Polygon PrepararPoligono() {
        return new Polygon(this.getCoordenadasX(), this.getCoordenadasY(), this.getNpuntos());
    }

    public int getNpuntos() {
        return npuntos;
    }

    public int[] getCoordenadasX() {
        return coordenadasX;
    }

    public int[] getCoordenadasY() {
        return coordenadasY;
    }

    public void setNpuntos(int npuntos){
        this.npuntos = npuntos;
    }

    public void setCoordenadasX(int[] coordenadasX) {
        this.coordenadasX = coordenadasX;
    }

    public void setCoordenadasY(int[] coordenadasY) {
        this.coordenadasY = coordenadasY;
    }
}
