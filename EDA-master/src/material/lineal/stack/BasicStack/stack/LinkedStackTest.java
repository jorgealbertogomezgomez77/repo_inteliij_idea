package material.lineal.stack.BasicStack.stack;

import material.lineal.stack.BasicStack.stack.LinkedStack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test class for LinkedStack
 * 
 * @author J. Vélez, A. Duarte, J. Sánchez-Oro
 */
public class LinkedStackTest {

    /**
     * Test of size method, of class LinkedStack.
     */
    @Test
    public void testSize() {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        assertEquals(stack.size(), 0);
        for (int i=0;i<10;i++) {
            stack.push(i);
            assertEquals(stack.size(), i+1);
        }
    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty() {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    /**
     * Test of top method, of class LinkedStack.
     */
    @Test(expected = IllegalStateException.class)
    public void testTopException() {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.top();
    }
    
    /**
     * Test of top method, of class LinkedStack.
     */
    @Test
    public void testTop() {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        assertEquals((int)stack.top(),1);
        stack.push(2);
        assertEquals((int)stack.top(),2);
    }

    /**
     * Test of push method, of class LinkedStack.
     */
    @Test
    public void testPush() {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        for (int i=0;i<10;i++) {
            stack.push(i);
            assertEquals((int)stack.top(), i);
        }
    }

    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test(expected = IllegalStateException.class)
    public void testPopException() {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.pop();
    }
    
    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop() {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        assertEquals((int)stack.pop(), 2);
        assertEquals((int)stack.top(), 1);
    }
    
}
