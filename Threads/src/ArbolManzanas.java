
public class ArbolManzanas {
    int actual = 0;
    int ultima = 0;
    boolean disponible = false;
    int[] arrayManzanas = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public ArbolManzanas() {
        actual = 0;
    }

    public synchronized int get() {
        try {
            while (disponible == false) {
                wait();
            }
        }
        catch (InterruptedException e) {

        }
        disponible = false;
        notifyAll();
        System.out.println("Se ha recogido la manzana " + this.arrayManzanas[ultima] + " del árbol de manzanas");
        return this.arrayManzanas[ultima];
    }

    public synchronized void put(int x) {
        try {
            while (disponible == true) {
                wait(); // Esperan los productores hasta que se consuma la manzana que han creado.
            }
        }
        catch (InterruptedException e) {

        }
        disponible = true;
        ultima = actual;
        this.arrayManzanas[actual++] = x;
        //System.out.println("Se a añadido una manzana a la cesta. " + this.arrayManzanas[ultima]);
        notifyAll();
    }
}
