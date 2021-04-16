package material.lineal.list;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class test for DoubleLinkedList
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 */
public class DoubleLinkedListTest {

    /**
     * Test of size method.
     */
    @Test
    public void testSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertEquals(0, list.size());
        list.addFirst(1);
        list.addLast(5);
        // [1, 5]
        assertEquals(2, list.size());
        list.addAfter(list.first(), 3);
        list.addBefore(list.last(), 4);
        // [1,3,4,5]
        assertEquals(4, list.size());
        list.remove(list.first());
        list.remove(list.last());
        // [3,4]
        assertEquals(2, list.size());
    }

    /**
     * Test of isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        assertTrue(list.isEmpty());
        list.addFirst(2);
        assertFalse(list.isEmpty());
        list.remove(list.first());
        assertTrue(list.isEmpty());
    }

    /**
     * Test of first method.
     */
    @Test(expected = IllegalStateException.class)
    public void testFirstEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.first();
    }

    public void testFirstNonEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(3);
        Position<Integer> pos = list.first();
        int element = pos.getElement();
        assertEquals(element, 3);
        list.addLast(4);
        pos = list.first();
        element = pos.getElement();
        assertEquals(element, 3);
        list.addFirst(2);
        pos = list.first();
        element = pos.getElement();
        assertEquals(element, 2);
    }

    /**
     * Test of last method.
     */
    @Test(expected = IllegalStateException.class)
    public void testLastEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.last();
    }

    /**
     * Test of last method.
     */
    public void testLastNonEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addLast(3);
        Position<Integer> pos = list.last();
        int element = pos.getElement();
        assertEquals(element, 3);
        list.addFirst(4);
        pos = list.last();
        element = pos.getElement();
        assertEquals(element, 3);
        list.addLast(2);
        pos = list.last();
        element = pos.getElement();
        assertEquals(element, 2);
    }

    /**
     * Test of prev method.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testPrevException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.prev(list.first());
    }

    /**
     * Test of prev method.
     */
    @Test
    public void testPrev() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        Position<Integer> pos = list.addAfter(list.first(), 4);
        // [1,4,2]
        int value = list.prev(list.last()).getElement();
        assertEquals(value, 4);
        value = list.prev(pos).getElement();
        assertEquals(value, 1);
    }

    /**
     * Test of next method.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testNextException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.next(list.first());
    }

    /**
     * Test of next method.
     */
    @Test
    public void testNext() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        Position<Integer> pos2 = list.addAfter(list.first(), 2);
        Position<Integer> pos3 = list.addAfter(pos2, 3);
        Position<Integer> pos4 = list.addAfter(pos3, 4);
        int elem2 = list.next(list.first()).getElement();
        int elem3 = list.next(pos2).getElement();
        int elem4 = list.next(pos3).getElement();
        assertEquals(elem2, 2);
        assertEquals(elem3, 3);
        assertEquals(elem4, 4);
    }

    /**
     * Test of addBefore method.
     */
    @Test
    public void testAddBefore() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        int value = list.first().getElement();
        assertEquals(value, 1);
        list.addBefore(list.first(), 3);
        value = list.first().getElement();
        assertEquals(value, 3);
    }

    /**
     * Test of addAfter method.
     */
    @Test
    public void testAddAfter() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        int value = list.first().getElement();
        assertEquals(value, 1);
        list.addAfter(list.last(), 3);
        value = list.last().getElement();
        assertEquals(value, 3);
    }

    /**
     * Test of addFirst method.
     */
    @Test
    public void testAddFirst() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(2);
        int value = list.first().getElement();
        assertEquals(value, 2);
        list.addFirst(3);
        value = list.first().getElement();
        assertEquals(value, 3);
    }

    /**
     * Test of addLast method.
     */
    @Test
    public void testAddLast() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addLast(2);
        int value = list.last().getElement();
        assertEquals(value, 2);
        list.addLast(3);
        value = list.last().getElement();
        assertEquals(value, 3);
    }

    /**
     * Test of remove method.
     */
    @Test
    public void testRemove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.remove(list.first());
        assertTrue(list.isEmpty());
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        int first = list.first().getElement();
        assertEquals(first, 3);
    }

    /**
     * Test of set method.
     */
    @Test
    public void testSet() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        Position<Integer> pos2 = list.addLast(2);
        list.addLast(3);
        list.set(pos2, 4);
        int value = pos2.getElement();
        assertEquals(value, 4);
        list.set(list.last(), 5);
        value = list.last().getElement();
        assertEquals(value, 5);
    }

    /**
     * Test of isFirst method.
     */
    @Test
    public void testIsFirst() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        Position<Integer> pos = list.addFirst(1);
        list.addLast(2);
        assertTrue(list.isFirst(list.first()));
        assertTrue(list.isFirst(pos));
        assertFalse(list.isFirst(list.last()));
    }

    /**
     * Test of isLast method, of class DoubleLinkedList.
     */
    @Test
    public void testIsLast() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        Position<Integer> pos = list.addLast(2);
        assertTrue(list.isLast(list.last()));
        assertTrue(list.isLast(pos));
        assertFalse(list.isLast(list.first()));
    }

    /**
     * Test of swapElements method.
     */
    @Test
    public void testSwapElements() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.swapElements(list.first(), list.last());
        int first = list.first().getElement();
        int last = list.last().getElement();
        assertEquals(first, 4);
        assertEquals(last, 1);
    }

    /**
     * Test of toString method, of class DoubleLinkedList.
     */
    @Test
    public void testToString() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        String textList = list.toString();
        assertEquals(textList, "[1,2,3,4]");
    }

    @Test
    public void testIterator() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        Iterator<Integer> it = list.iterator();
        assertEquals((int)it.next(), 1);
        assertEquals((int)it.next(), 2);
        assertEquals((int)it.next(), 3);
        assertEquals((int)it.next(), 4);
    }

}
