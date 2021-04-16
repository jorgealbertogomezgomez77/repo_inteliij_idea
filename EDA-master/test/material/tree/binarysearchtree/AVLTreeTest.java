package material.tree.binarysearchtree;

import material.tree.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David R on 15/06/2016.
 */
public class AVLTreeTest {

    @Test
    public void testFindRange() {
        AVLTree<Integer> b = new AVLTree<>();
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
        AVLTree<String> b = new AVLTree<>();
        b.insert("5");
        b.insert("3");
        b.insert("6");
        b.insert("7");
        Position<String> a = b.insert("1");
        b.insert("4");
        String salida = "1";
        assertEquals(b.first().getElement(), a.getElement());

    }

    @Test
    public void testLast() {
        AVLTree<Integer> b = new AVLTree<>();
        b.insert(5);
        b.insert(3);
        b.insert(6);
        Position<Integer> a = b.insert(7);
        b.insert(1);
        b.insert(4);
        System.out.println("last: "+ b.last().getElement().toString());

        assertEquals(b.last().getElement(), a.getElement());
    }

    @Test
    public void testPredecessors() {  //Mas pequeños
        AVLTree<Integer> b = new AVLTree<>();
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
        AVLTree<Integer> b = new AVLTree<>();
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