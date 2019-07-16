package material.tree.binarysearchtree;

import material.tree.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David R on 15/06/2016.
 */
public class LinkedBinarySearchTreeTest {

    @Test
    public void testFindRange() {
        LinkedBinarySearchTree<Integer> b = new LinkedBinarySearchTree<>();
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

        assertEquals(salida, "5467");
    }

    @Test
    public void testFirst() {
        LinkedBinarySearchTree<Integer> b = new LinkedBinarySearchTree<>();
        b.insert(5);
        b.insert(3);
        b.insert(6);
        b.insert(7);
        b.insert(1);
        b.insert(4);
        String salida = "1";
        assertEquals(b.first().getElement().toString(), salida);

    }

    @Test
    public void testLast() {
        LinkedBinarySearchTree<Integer> b = new LinkedBinarySearchTree<>();
        b.insert(5);
        b.insert(3);
        b.insert(6);
        b.insert(7);
        b.insert(1);
        b.insert(4);
        String salida = "7";
        assertEquals(b.last().getElement().toString(), salida);
    }

    @Test
    public void testSuccessors() {  //Mas grandes
        LinkedBinarySearchTree<Integer> b = new LinkedBinarySearchTree<>();
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

    @Test
    public void testPredecessors() {
        LinkedBinarySearchTree<Integer> b = new LinkedBinarySearchTree<>();
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
}