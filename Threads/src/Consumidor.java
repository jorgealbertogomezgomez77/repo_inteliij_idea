
import java.util.ArrayList;
import java.util.Iterator;
import static java.lang.Thread.sleep;

public class Consumidor implements Runnable{
    ArbolManzanas cesta;
    static int idconsumidor = 0;
    int myid;
    ArrayList<Integer> micestapropia;

    public Consumidor(ArbolManzanas cestacomun) {
        cesta = cestacomun;
        myid = idconsumidor;
        idconsumidor ++;
        micestapropia = new ArrayList<Integer>();
    }

    public void imprimeCesta() {
        Iterator<Integer> it = micestapropia.iterator();
        System.out.println("El consumidor " + myid + " tiene");
        while (it.hasNext()) {
            int nummanzana = it.next();
            System.out.print(" | " + nummanzana + " | ");
        }
        System.out.println();
    }

    @Override
    public void run() {
        for (int i = 0; i < cesta.arrayManzanas.length/2; i++) {
            try {
                int manzanarecogida = cesta.get();
                micestapropia.add(manzanarecogida);
                System.out.println("El consumidor " + myid + " ha comprado la manzana " + manzanarecogida);
                System.out.println("---------------------------------------------------");
                sleep(1);
            }
            catch (InterruptedException e) {

            }
        }
        this.imprimeCesta();
    }
}
