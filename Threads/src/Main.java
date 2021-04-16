
public class Main {
    public static void main(String[] args) {
        ArbolManzanas a = new ArbolManzanas();
        Consumidor c = new Consumidor(a);
        Consumidor c2 = new Consumidor(a);
        Productor p = new Productor(a);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c2);
        t1.start();
        t2.start();
        t3.start();
    }
}
