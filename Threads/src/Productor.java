import static java.lang.Thread.sleep;

public class Productor implements Runnable{
    ArbolManzanas cesta;
    static int idproductor;

    public Productor(ArbolManzanas cestacomun) {
        cesta = cestacomun;
        idproductor ++;
    }

    @Override
    public void run() {
        for (int i = 0; i < cesta.arrayManzanas.length; i++) {
            try {
                cesta.put(i);
                System.out.println("El productor " + idproductor + " ha añadido a la cesta comun la manzana " + i);
                sleep(1);
            }
            catch (InterruptedException e) {

            }
        }
    }
}
