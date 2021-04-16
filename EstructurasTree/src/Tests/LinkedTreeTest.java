package Tests;

import TreeStructure.LinkedTree.LinkedTree;
import TreeStructure.Tree.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedTreeTest {

    @Test
    public void testSize() {
        LinkedTree<String> t = new LinkedTree<String>();
        Position<String> p = t.addRoot("a");
        Position<String> p1 = t.add(p, "b");
        Position<String> p2 = t.add(p, "c");
        t.add(p1, "d");
        t.add(p1, "e");
        t.add(p2, "f");
        t.add(p2, "g");
        t.add(p2, "h");
        assertEquals(t.size(), 8);
    }

    @Test
    public void testRemove() {
        LinkedTree<String> t = new LinkedTree<String>();
        Position<String> p = t.addRoot("a");
        Position<String> p1 = t.add(p, "b");
        Position<String> p2 = t.add(p, "b");
        t.add(p1, "d");
        t.add(p1, "e");
        t.add(p2, "f");
        t.add(p2, "g");
        t.add(p2, "h");
        t.remove(p2);
    }

    @Test
    public void testElementos() {
        LinkedTree<String> t = new LinkedTree<String>();
        Position<String> p = t.addRoot("a");
        Position<String> p1 = t.add(p, "b");
        Position<String> p2 = t.add(p, "c");
        t.add(p1, "d");
        t.add(p1, "e");
        t.add(p2, "f");
        t.add(p2, "g");
        t.add(p2, "h");
        String salida = "";
        for (Position<String> e: t.position()) {
            salida += e.elemento();
        }
        assertEquals(salida, "abdecfgh");
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
}