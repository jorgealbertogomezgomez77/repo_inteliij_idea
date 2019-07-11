/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.tree.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import material.tree.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author J. Vélez, A. Duarte, J. Sánchez-Oro
 */
public class LinkedBinaryTreeTest {
    
    /**
     * Test of size method, of class LinkedBinaryTree.
     */
    @Test
    public void testSize() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        assertEquals(t.size(), 1);
    }

    /**
     * Test of isEmpty method, of class LinkedBinaryTree.
     */
    @Test
    public void testIsEmpty() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        assertTrue(t.isEmpty());
    }

    /**
     * Test of isInternal method, of class LinkedBinaryTree.
     */
    @Test
    public void testIsInternal() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2");
        assertTrue(t.isInternal(p));
    }

    /**
     * Test of isLeaf method, of class LinkedBinaryTree.
     */
    @Test
    public void testIsLeaf() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        assertTrue(t.isLeaf(p));
    }

    /**
     * Test of isRoot method, of class LinkedBinaryTree.
     */
    @Test
    public void testIsRoot() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        assertTrue(t.isRoot(p));
    }

    /**
     * Test of hasLeft method, of class LinkedBinaryTree.
     */
    @Test
    public void testHasLeft() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2");
        assertTrue(t.hasLeft(p));
    }

    /**
     * Test of hasRight method, of class LinkedBinaryTree.
     */
    @Test
    public void testHasRight() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> h = t.insertRight(p, "*");
        assertTrue(t.hasRight(p));
    }

    /**
     * Test of root method, of class LinkedBinaryTree.
     */
    @Test
    public void testRoot() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        t.insertLeft(h, "3");
        Position<String> n5 = t.insertRight(h, "5");
        assertEquals(t.root(), p);
        assertNotSame(t.root(), h);
    }

    /**
     * Test of left method, of class LinkedBinaryTree.
     */
    @Test
    public void testLeft() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        assertEquals(t.left(p), n2);
    }

    /**
     * Test of right method, of class LinkedBinaryTree.
     */
    @Test
    public void testRight() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> h = t.insertRight(p, "*");
        assertEquals(t.right(p), h);
    }
    
    /**
     * Test of parent method, of class LinkedBinaryTree.
     */
    @Test
    public void testParent() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        assertEquals(t.parent(n2), p);
    }

    /**
     * Test of children method, of class LinkedBinaryTree.
     */
    @Test
    public void testChildren() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        List<Position<String>> myChildren = new ArrayList<>();
        myChildren.add(n2);
        myChildren.add(h);
        Iterator<Position<String>> myIt = myChildren.iterator();
        for (Position<String> child : t.children(p)) {
            Position<String> next = myIt.next();
            assertEquals(child, next);
        }
    }

    /**
     * Test of iterator method, of class LinkedBinaryTree.
     */
    @Test
    public void testIterator() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2");
        t.insertRight(p, "3");
        String salida = "";
        for (Position<String> e : t) {
            salida += e.getElement();
        }
        assertEquals(salida, "+23");
    }

    /**
     * Test of replace method, of class LinkedBinaryTree.
     */
    @Test
    public void testReplace() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        t.replace(p, "-");
        assertEquals(p.getElement(), "-");
    }

    /**
     * Test of sibling method, of class LinkedBinaryTree.
     */
    @Test
    public void testSibling() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        assertEquals(t.sibling(n2),h);
    }

    /**
     * Test of addRoot method, of class LinkedBinaryTree.
     */
    @Test
    public void testAddRoot() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        assertEquals(t.root(), p);
    }

    /**
     * Test of insertLeft method, of class LinkedBinaryTree.
     */
    @Test
    public void testInsertLeft() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        assertEquals(t.left(p), n2);
    }

    /**
     * Test of insertRight method, of class LinkedBinaryTree.
     */
    @Test
    public void testInsertRight() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> h = t.insertRight(p, "*");
        assertEquals(t.right(p), h);
    }

    /**
     * Test of remove method, of class LinkedBinaryTree.
     */
    @Test
    public void testRemove() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> q = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        t.remove(q);
        assertEquals(t.size(), 2);
    }

    /**
     * Test of swapElements method, of class LinkedBinaryTree.
     */
    @Test
    public void testSwapElements() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> p1 = t.insertLeft(p, "2");
        Position<String> p2 = t.insertRight(p, "3");
        t.swapElements(p1, p2);
        String salida = "";
        for (Position<String> e : t) {
            salida += e.getElement();
        }
        assertEquals(salida, "+32");
    }

    /**
     * Test of subTree method, of class LinkedBinaryTree.
     */
    @Test
    public void testSubTree() {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        Position<String> n3 = t.insertLeft(h, "3");
        Position<String> n5 = t.insertRight(h, "5");
        t.subTree(h);
        assertEquals(t.root(), h);
        assertEquals(t.left(t.root()), n3);
        assertEquals(t.right(t.root()), n5);
        
    }

    @Test
    public void testRemoveSubTree(){
        LinkedBinaryTree<String> t = new LinkedBinaryTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.insertLeft(a, "B");
        Position<String> c = t.insertRight(a, "C");
        Position<String> d = t.insertLeft(b, "D");
        Position<String> e = t.insertRight(b, "E");
        Position<String> f = t.insertLeft(e, "F");
        Position<String> g = t.insertRight(e, "G");
        Position<String> h = t.insertRight(f, "H");

        t.removeSubtree(e);

        assertEquals(t.size(), 4);
        assertEquals(t.hasRight(b), false);
    }
}
