package material.tree;

import material.tree.iterator.BFSIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by David R on 03/06/2016.
 */
public class LCRSTreeTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSize() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        assertEquals(t.size(), 0);
        Position<String> a = t.addRoot("A");
        assertEquals(t.size(), 1);
    }

    @Test
    public void testIsEmpty() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        assertTrue(t.isEmpty());
    }

    @Test
    public void testIsInternal() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertTrue(t.isInternal(b));
    }

    @Test
    public void testIsLeaf() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        assertTrue(t.isLeaf(a));
    }

    @Test
    public void testIsRoot() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        assertTrue(t.isRoot(a));
    }

    @Test
    public void testRoot() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        assertEquals(t.root(), a);
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertEquals(t.root(), a);
    }

    @Test
    public void testParent() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertEquals(t.parent(b), a);
    }

    @Test
    public void testChildren() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        Set<Position<String>> myChildren = new HashSet<>();
        myChildren.add(b);
        myChildren.add(c);
        for (Position<String> node : t.children(a)) {
            assertTrue(myChildren.contains(node));
        }
    }

    @Test
    public void testReplace() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertEquals(d.getElement(), "D");
        t.replace(d, "nuevo");
        assertEquals(d.getElement(), "nuevo");
    }

    @Test
    public void testAddRoot() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        assertEquals(a, t.root());
    }

    @Test
    public void testSwapElements() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        t.swapElements(a, b);
        assertEquals(b.getElement(), "A");
        assertEquals(a.getElement(), "B");
    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        t.remove(d);
        Iterator<Position<String>> it = new BFSIterator<>(t,t.root());
        while (it.hasNext()) {
            Position<String> node = it.next();
            assertNotSame(node.getElement(),d);
        }
    }

    @Test
    public void setIterator() throws Exception {

    }

    @Test
    public void iterator() throws Exception {

    }

    @Test
    public void testMoveSubtree() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        Position<String> e = t.add("E", c);
        Position<String> f = t.add("F", c);
        Position<String> g = t.add("G", e);
        t.moveSubtree(c,d);
        assertEquals (t.parent(c).getElement(), "D" );

        List<Position<String>> listaHijosC = (List<Position<String>>) t.children(c);
        assertEquals(listaHijosC.contains(e), true);
        assertEquals(listaHijosC.contains(f), true);

        List<Position<String>> listaHijosE = (List<Position<String>>) t.children(e);
        assertEquals(listaHijosE.contains(g), true);

        List<Position<String>> listaHijosA = (List<Position<String>>) t.children(a);
        assertEquals(listaHijosA.size(),1);
        assertEquals(listaHijosA.contains(b),true);
    }
}