package Tests;

import Lista.DoubleLinkedList;
import Lista.Nodo;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleLinkedListTest {
    DoubleLinkedList<String> dl;

    @Test
    public void testSize() {
        dl = new DoubleLinkedList<String>();
        assertEquals(dl.size(), 0);
    }

    @Test
    public void testSize2() throws Exception {
        this.setUp();
        assertEquals(dl.size(), 12);
    }

    @Test
    public void testAddFirst() throws Exception {
        this.setUp();
        dl.addFirst("nuevo");
        assertEquals(dl.getFirst(), "nuevo");
    }

    @Test
    public void testAddIndex() throws Exception {
        this.setUp();
        //dl = new DoubleLinkedList<String>();
        dl.add("Buscame", 5);
        assertEquals(dl.get(5), "Buscame");
    }

    @Test
    public void testResultado() throws Exception {
        this.tearDown();
        this.setUp();
        Iterable<Nodo<String>> ite = dl.iterator();
        Iterator it = ite.iterator();
        String salida = "";
        while (it.hasNext()) {
            Nodo<String> nodo = (Nodo<String>) it.next();
            salida += nodo.getElemento();
        }
        assertEquals(salida, "123456789123");
    }

    @Before
    public void setUp() throws Exception {
        dl = new DoubleLinkedList<String>();
        dl.addLast("1");
        dl.addLast("2");
        dl.addLast("3");
        dl.addLast("4");
        dl.addLast("5");
        dl.addLast("6");
        dl.addLast("7");
        dl.addLast("8");
        dl.addLast("9");
        dl.addLast("1");
        dl.addLast("2");
        dl.addLast("3");
    }

    @After
    public void tearDown() throws Exception {
        dl = new DoubleLinkedList<String>();

    }
}