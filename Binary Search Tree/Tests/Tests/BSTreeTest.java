package Tests;

import BinarySearchTree.BSTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BSTreeTest {

    public BSTreeTest() {

    }

    @Test
    public void testSize() {
        BSTree<Integer> b = new BSTree<Integer>();
        assertEquals(b.size(), 0);
        b.insert(10);
        b.insert(15);
        b.insert(5);
        b.insert(14);
        b.insert(4);
        assertEquals(b.size(), 5);
        b.insert(10);
        assertEquals(b.size(), 2);
        for (int i = 0; i < 30; i++) {
            b.insert(i);
            assertEquals(b.size(), 30);
        }
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}