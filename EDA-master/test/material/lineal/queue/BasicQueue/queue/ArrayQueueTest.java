package material.lineal.queue.BasicQueue.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 15/04/2016.
 */
public class ArrayQueueTest {
    private ArrayQueue t ;

    @Before
    public void setUp() throws Exception {
        t = new ArrayQueue<Integer>(10);
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(t.size(), 0);
        t.enqueue(1);
        assertEquals(t.size(), 1);
        t.enqueue(2);
        assertEquals(t.size(), 2);
        t.enqueue(3);
        assertEquals(t.size(), 3);
        t.enqueue(4);
        assertEquals(t.size(), 4);
        t.enqueue(5);
        assertEquals(t.size(), 5);
        t.enqueue(6);
        assertEquals(t.size(), 6);
        t.dequeue();
        assertEquals(t.size(), 5);
        t.dequeue();
        assertEquals(t.size(), 4);
        t.enqueue(5);
        assertEquals(t.size(), 5);
        t.enqueue(6);
        assertEquals(t.size(), 6);
        t.dequeue();
        assertEquals(t.size(), 5);
        t.dequeue();
        assertEquals(t.size(), 4);
        t.dequeue();
        assertEquals(t.size(), 3);
        t.dequeue();
        assertEquals(t.size(), 2);
        t.dequeue();
        assertEquals(t.size(), 1);
        t.dequeue();
        assertEquals(t.size(), 0);
        t.enqueue(2);
        assertEquals(t.size(), 1);
        t.enqueue(2);
        assertEquals(t.size(), 2);
        t.enqueue(3);
        assertEquals(t.size(), 3);
        t.enqueue(4);
        assertEquals(t.size(), 4);
        t.enqueue(5);
        assertEquals(t.size(), 5);
        t.enqueue(6);
        assertEquals(t.size(), 6);
    }
    @Test (expected = IllegalStateException.class)
    public void testFullArrayException(){
        for (int i =0; i<20; i++){
            t.enqueue(i);
        }
        System.out.println("está saltando la excepcion");
    }

    @Test
    public void testIsEmpty() throws Exception {

        assertEquals(t.isEmpty(), true);
        t.enqueue(1);
        System.out.println("primer elemento de la cola: "+ t.front());
        assertEquals(t.isEmpty(), false);
        t.enqueue(2);
        assertEquals(t.isEmpty(), false);

        //la llenemos completamente y luego la vaciamos
        for (int i =0; i<7; i++){
            t.enqueue(i);
        }
        assertEquals(t.isEmpty(), false);

        for (int i =0; i<9; i++){
            t.dequeue();
        }
        assertEquals(t.isEmpty(), true);

    }

    @Test
    public void front() throws Exception {
        t.enqueue(0);
        assertEquals(t.front(), 0);
        t.enqueue(1);
        assertEquals(t.front(), 0);
        t.dequeue();
        t.dequeue();
        t.enqueue(13);
        assertEquals(t.front(), 13);
    }

    @Test
    public void enqueue() throws Exception {
        assertEquals(t.size(), 0);
        t.enqueue(0);
        assertEquals(t.size(), 1);
        assertEquals(t.front(), 0);
        t.enqueue(9);
        assertEquals(t.size(), 2);
        assertEquals(t.front(), 0);
    }

    @Test
    public void dequeue() throws Exception {
        assertEquals(t.size(), 0);
        t.enqueue(1);
        t.enqueue(2);
        t.enqueue(3);
        t.enqueue(4);
        t.enqueue(5);
        assertEquals(t.size(), 5);
        assertEquals(t.front(), 1);
        t.dequeue();
        assertEquals(t.size(), 4);
        assertEquals(t.front(), 2);
        t.dequeue();
        assertEquals(t.size(), 3);
        assertEquals(t.front(), 3);
        t.dequeue();
        assertEquals(t.size(), 2);
        assertEquals(t.front(), 4);
        t.dequeue();
        assertEquals(t.size(), 1);
        assertEquals(t.front(), 5);
        t.dequeue();
        assertEquals(t.isEmpty(), true);
        assertEquals(t.size(), 0);
    }

}