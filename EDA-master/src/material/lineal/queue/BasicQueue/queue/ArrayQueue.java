package material.lineal.queue.BasicQueue.queue;


//import java.util.EmptyStackException;

/**
 * Queue implemented using an array
 *
 * @author J. Vélez, A. Duarte, J. Sánchez-Oro
 *
 * @param <E> Type of the elements stored in the queue
 */
public class ArrayQueue<E> implements Queue<E> {

    //private int top; // Position of the top of the queue
    private int head;  // Por donde se introducen elementos
    private int tail;  // Por donde se extraen elementos
    private int max;  // Tamaño maximo de la cola

    private E[] s; // Array containing the elements in the queue

    /**
     * Constructor of the class with the initial capacity.
     *
     * @param capacity maximum initial size of the queue.
     */
    public ArrayQueue(final int capacity) {
        head = 0;
        tail = 0;
        max = capacity;
        s = (E[]) new Object[capacity];
    }
    @Override
    public int size() {
        return ((max - head + tail) % max);
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public E front(){
        if (isEmpty()){
            throw new IllegalStateException();
        }
        return s[head];

    }
   @Override
    public void enqueue (E element){
        if (size() == max-1 ){
            //hacer excepcion especifica para array lleno
            throw new IllegalStateException();
        }
        s[tail]=element;
        tail = (tail + 1) % max;

    }

    //metodo dequeue
    @Override
    public E dequeue(){
        if(isEmpty()){
            //hacer excepcion especifica para array vacio
            throw new IllegalStateException();
        }
        E temp = s[head];
        s[head] = null;
        head = ((head +1) % max);
        return temp;
    }
}
