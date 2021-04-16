package material.tree.binarysearchtree;

import material.tree.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David R on 15/06/2016.
 */
public class RBTreeTest {

    @Test
    public void testFindRange() {
        RBTree<Integer> b = new RBTree<>();
        b.insert(5);
        b.insert(6);
        b.insert(8);
        b.insert(2);
        b.insert(9);
        b.insert(4);
        b.insert(7);
        String salida = "";
        Iterable<Position<Integer>> i = b.findRange(3, 7);
        for (Position<Integer> e : i) {
            salida += e.getElement().toString();
        }
        System.out.println(salida);

        assertEquals(salida, "6457");
    }
    @Test
    public void testFirst() {
        RBTree<String> b = new RBTree<>();
        b.insert("5");
        b.insert("3");
        b.insert("6");
        b.insert("7");
        Position<String> a = b.insert("1");
        b.insert("4");

        assertEquals(b.first().getElement(), a.getElement());
    }

    @Test
    public void testLast() {
        RBTree<Integer> b = new RBTree<>();
        b.insert(5);
        b.insert(3);
        b.insert(6);
        Position<Integer> a = b.insert(7);
        b.insert(1);
        b.insert(4);

        assertEquals(b.last().getElement(), a.getElement());
    }

    @Test
    public void testPredecessors() {  //Mas pequeños
        RBTree<Integer> b = new RBTree<>();
        Position<Integer> p = b.insert(5);
        b.insert(3);
        b.insert(6);
        b.insert(7);
        b.insert(1);
        b.insert(4);
        String salida = "";
        Iterable<Position<Integer>> i = b.predecessors(p);
        for (Position<Integer> e : i) {
            salida += e.getElement().toString();
        }
        assertEquals(salida, "314");
    }

    @Test
    public void testSuccessors() {
        RBTree<Integer> b = new RBTree<>();
        Position<Integer> p = b.insert(5);
        b.insert(3);
        b.insert(6);
        b.insert(7);
        b.insert(1);
        b.insert(4);
        String salida = "";
        Iterable<Position<Integer>> i = b.successors(p);
        for (Position<Integer> e : i) {
            salida += e.getElement().toString();
        }
        assertEquals(salida, "67");
    }

}