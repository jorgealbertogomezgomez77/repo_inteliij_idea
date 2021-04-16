package material.tree.binarytree;

import material.tree.Position;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import material.tree.Position;
import material.tree.binarytree.ArrayBinaryTree;
import material.tree.binarytree.BinaryTree;
import material.tree.binarytree.BinaryTreeUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * Created by David R on 12/06/2016.
 */
public class ArrayBinaryTreeTest {
    /**
     * Test of size method, of class ArrayBinaryTree.
     */
    @Test
    public void testSize() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");

        assertEquals(t.size(), 1);
    }

    /**
     * Test of isEmpty method, of class ArrayBinaryTree.
     */
    @Test
    public void testIsEmpty() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        assertTrue(t.isEmpty());
    }

    /**
     * Test of isInternal method, of class ArrayBinaryTree.
     */
    @Test
    public void testIsInternal() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2");
        assertTrue(t.isInternal(p));
    }

    /**
     * Test of isLeaf method, of class ArrayBinaryTree.
     */
    @Test
    public void testIsLeaf() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        assertTrue(t.isLeaf(p));
    }

    /**
     * Test of isRoot method, of class ArrayBinaryTree.
     */
    @Test
    public void testIsRoot() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        assertTrue(t.isRoot(p));
    }

    /**
     * Test of hasLeft method, of class ArrayBinaryTree.
     */
    @Test
    public void testHasLeft() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2");
        assertTrue(t.hasLeft(p));
    }

    /**
     * Test of hasRight method, of class ArrayBinaryTree.
     */
    @Test
    public void testHasRight() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> h = t.insertRight(p, "*");
        assertTrue(t.hasRight(p));
    }

    /**
     * Test of root method, of class ArrayBinaryTree.
     */
    @Test
    public void testRoot() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        t.insertLeft(h, "3");
        Position<String> n5 = t.insertRight(h, "5");
        assertTrue(t.isRoot(p));
        assertNotSame(t.root(), h);
    }

    /**
     * Test of left method, of class ArrayBinaryTree.
     */
    @Test
    public void testLeft() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");

        Position<String> st = t.left(p);
        assertTrue(t.left(p).equals(n2));
    }

    /**
     * Test of right method, of class ArrayBinaryTree.
     */
    @Test
    public void testRight() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> h = t.insertRight(p, "*");
        assertTrue(t.right(p).equals(h));
    }

    /**
     * Test of parent method, of class ArrayBinaryTree.
     */
    @Test
    public void testParent() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        assertTrue(t.parent(n2).equals(p));
    }

    /**
     * Test of children method, of class ArrayBinaryTree.
     */
    @Test
    public void testChildren() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        List<Position<String>> myChildren = new ArrayList<>();
        myChildren.add(n2);
        myChildren.add(h);
        List<Position<String>> children = (ArrayList<Position<String>>) t.children(p);
//        Iterator<Position<String>> myIt = myChildren.iterator();
//        for (Position<String> child : t.children(p)) {
//            Position<String> next = myIt.next();
//            assertEquals(child, next);
//        }
        assertTrue(myChildren.equals(children));
    }

    /**
     * Test of iterator method, of class ArrayBinaryTree.
     */
    @Test
    public void testIterator() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        t.insertLeft(p, "2");
        t.insertRight(p, "3");
        String salida = "";
        for (Position<String> e : t) {
            if (e != null) {
                salida += e.getElement();
            }
        }
        assertEquals(salida, "+23");
    }

    /**
     * Test of replace method, of class ArrayBinaryTree.
     */
    @Test
    public void testReplace() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        t.replace(p, "-");
        assertEquals(p.getElement(), "-");
    }

    /**
     * Test of sibling method, of class ArrayBinaryTree.
     */
    @Test
    public void testSibling() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        assertTrue(t.sibling(n2).equals(h));
    }

    @Test(expected = IllegalStateException.class)
    public void testSibling2() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(n2, "*");
        t.sibling(n2);
    }

    /**
     * Test of addRoot method, of class ArrayBinaryTree.
     */
    @Test
    public void testAddRoot() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        assertTrue(t.root().equals(p));
    }

    /**
     * Test of insertLeft method, of class ArrayBinaryTree.
     */
    @Test
    public void testInsertLeft() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        assertTrue(t.left(p).equals(n2));
    }

    /**
     * Test of insertRight method, of class ArrayBinaryTree.
     */
    @Test
    public void testInsertRight() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> h = t.insertRight(p, "*");
        assertTrue(t.right(p).equals(h));
    }

    /**
     * Test of remove method, of class ArrayBinaryTree.
     */
    @Test
    public void testRemove() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> q = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        t.remove(q);
        assertEquals(t.size(), 2);
        //System.out.println("Tamaño: " + t.size());
        assertEquals(t.hasRight(p), true);
        //System.out.println("Hijo derecho: " + t.right(p).getElement());
        assertEquals(t.hasLeft(p), false);

    }

    /**
     * Test of removeSubtree method, of class ArrayBinaryTree.
     */
    //@Test
    /*public void testRemoveSubtree() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(100);
        Position<String> a = t.addRoot("A");
        Position<String> b = t.insertLeft(a, "B");
        Position<String> c = t.insertRight(a, "C");
        Position<String> d = t.insertLeft(b, "D");
        Position<String> e = t.insertRight(b, "E");
        Position<String> f = t.insertLeft(e, "F");
        Position<String> g = t.insertRight(e, "G");
        Position<String> h = t.insertRight(f, "H");
        int tam = t.size();
        System.out.println("remSubTam" + tam);
        t.removeSubtree(e);
        String salida = "";
        int cont = 0;  //Cuento las posiciones ocupadas que quedan
        //ya que las posiciones que han sido eliminadas se cuentan en size
        for (Position<String> p : t) {
            salida += p.getElement();
            System.out.println("remSub" + salida);
            cont++;
        }
        System.out.println("remSubTam2 " + t.size());
        System.out.println("remSubTam2 " + cont);
        assertEquals(cont, 4);
        assertEquals(t.size(), 4);
        assertEquals(t.hasRight(b), false);
    }*/

    /**
     * Test of swapElements method, of class ArrayBinaryTree.
     */
    @Test
    public void testSwapElements() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
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
     * Test of subTree method, of class ArrayBinaryTree.
     */
    //@Test
   /* public void testSubTree() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        Position<String> n3 = t.insertLeft(h, "3");
        Position<String> n5 = t.insertRight(h, "5");
        t.subTree(h);

        assertTrue(t.root().equals(h));
        assertTrue(t.left(t.root()).equals(n3));
        assertTrue(t.right(t.root()).equals(n5));
        assertEquals(t.size(), 3);
        System.out.println("Raiz: " + t.root().getElement());
        System.out.println("Derecho: " + t.right(t.root()).getElement());
        System.out.println("Izquierdo: " + t.left(t.root()).getElement());
    }*/

    @Test
    public void testToString() {

    }

    @Test
    public void testContains() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> p = t.addRoot("+");
        Position<String> n2 = t.insertLeft(p, "2");
        Position<String> h = t.insertRight(p, "*");
        Position<String> n3 = t.insertLeft(h, "3");
        Position<String> n5 = t.insertRight(h, "5");
        BinaryTreeUtils btu = new BinaryTreeUtils(t);
        assertTrue(btu.contains(h.getElement()));
    }

    @Test
    public void testLevel() {
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10);
        Position<String> a = t.addRoot("A");
        Position<String> b = t.insertLeft(a, "B");
        Position<String> c = t.insertRight(a, "C");
        Position<String> d = t.insertLeft(b, "D");
        Position<String> e = t.insertRight(b, "E");
        Position<String> f = t.insertLeft(e, "F");
        Position<String> g = t.insertRight(e, "G");
        Position<String> h = t.insertRight(f, "H");

        BinaryTreeUtils btu = new BinaryTreeUtils(t);
        assertEquals(btu.level(h),5);
    }

    @Test
    public void testMirror(){
        ArrayBinaryTree<String> t = new ArrayBinaryTree<>(10000);
        Position<String> a = t.addRoot("A");
        Position<String> b = t.insertLeft(a, "B");
        Position<String> c = t.insertRight(a, "C");
        Position<String> d = t.insertLeft(b, "D");
        Position<String> e = t.insertRight(b, "E");
        Position<String> f = t.insertLeft(e, "F");
        Position<String> g = t.insertRight(e, "G");
        Position<String> h = t.insertRight(f, "H");

        ArrayBinaryTree<String> tSol = new ArrayBinaryTree<>(10000);
        Position<String> i = tSol.addRoot("A");
        Position<String> j = tSol.insertLeft(i, "C");
        Position<String> k = tSol.insertRight(i, "B");
        Position<String> l = tSol.insertLeft(k, "E");
        Position<String> m = tSol.insertRight(k, "D");
        Position<String> n = tSol.insertLeft(l, "G");
        Position<String> o = tSol.insertRight(l, "F");
        Position<String> p = tSol.insertLeft(o, "H");

        BinaryTreeUtils btu = new BinaryTreeUtils(t);
        BinaryTree<String> tree = btu.mirror();
        Iterator<Position<String>> it = tSol.iterator();
        String arbol= "";
        String arbol2 = "";
        while(it.hasNext()){
            Position<String> aux = it.next();
            System.out.println("tSol  " + aux.getElement());
            arbol = arbol + aux.getElement();
        }
        Iterator<Position<String>> it2 = btu.mirror().iterator();
        while(it2.hasNext()){
            Position<String> aux2 = it2.next();
            System.out.println("mirror  " + aux2.getElement());
            arbol2 = arbol2 + aux2.getElement();
        }
        assertEquals(arbol, arbol2);
    }


}