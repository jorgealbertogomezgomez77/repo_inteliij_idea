package Test;

import LinkedBinaryTree.Position;
import LinkedBinaryTree.LinkedBinaryTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedBinaryTreeTest {

    public LinkedBinaryTreeTest() {

    }

    @Test
    public void testSize() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("a");
        Position<String> p1 = t.addLeft(p, "b");
        Position<String> p2 = t.addRight(p, "c");
        t.addLeft(p1, "d");
        t.addRight(p1, "e");
        t.addLeft(p2, "f");
        t.addRight(p2, "g");
        assertEquals(t.size(), 6);
    }

    @Test
    public void testRemove() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("a");
        Position<String> p1 = t.addLeft(p, "b");
        Position<String> p2 = t.addRight(p, "c");
        t.addLeft(p1, "d");
        t.addLeft(p2, "f");
        t.addRight(p2, "g");
        System.out.println("asas");
        t.remove(p1);
        System.out.println("asas");
        assertEquals(t.size(), 4);
    }

    @Test
    public void testElementos() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("a");
        Position<String> p1 = t.addLeft(p, "b");
        Position<String> p2 = t.addRight(p, "c");
        t.addLeft(p1, "d");
        t.addRight(p1, "e");
        t.addLeft(p2, "f");
        t.addRight(p2, "g");
        assertEquals(t.size(), 6);
        String salida = "";
        for (Position<String> e : t.position()) {
            salida += e.elemento();
        }
        assertEquals(salida, "abdecfg");
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}