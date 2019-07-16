package material.maps;

import static org.junit.Assert.*;

/**
 * Created by David R on 14/06/2016.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import material.maps.Entry;
import material.maps.HashTableMapSC;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashTableMapSCTest {

    public HashTableMapSCTest() {

    }

    public void setUp(HashTableMapSC<Integer, String> testMap) throws Exception {
        testMap.put(1, "uno");
        testMap.put(2, "dos");
        testMap.put(3, "tres");
        testMap.put(4, "cuatro");
        testMap.put(5, "cinco");
        testMap.put(6, "seis");
        testMap.put(7, "siete");
        testMap.put(8, "ocho");
        testMap.put(9, "nueve");
        testMap.put(10, "diez");
        testMap.put(11, "once");
        testMap.put(12, "doce");
        testMap.put(13, "trece");
        testMap.put(14, "catorce");
        testMap.put(15, "quince");
    }

    @Test
    public void testSize() throws Exception {
        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<Integer, String>();
        assertEquals(testMap.size(), 0);
        setUp(testMap);
        assertEquals(testMap.size(), 15);
    }

    @Test
    public void testIsEmpty() throws Exception {
        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<>();
        assertTrue(testMap.isEmpty());
    }

    //    @Test
//    public void testKeySet() throws Exception {
//        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<Integer, String>();
//        Iterable<Integer> keySet = testMap.keys();
//        Iterator<Integer> iterator = keySet.iterator();
//        List<Integer> keyList = new ArrayList<Integer>();
//        while (iterator.hasNext()) {
//            keyList.add(iterator.next());
//        }
//        assertEquals(keyList.size(), 0);
//    }
    @Test
    public void testKeySet() throws Exception {

        // Part 1: empty map
        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<Integer, String>();
        Iterable<Integer> keySet = testMap.keys();
        Iterator<Integer> iterator = keySet.iterator();
        List<Integer> keyList = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            keyList.add(iterator.next());
        }
        assertEquals(keyList.size(), 0);

        // Part 2: non empty map
        HashTableMapSC<Integer, String> testMap2 = new HashTableMapSC<Integer, String>();
        setUp(testMap2);
        Iterable<Integer> keySet2 = testMap2.keys();
        Iterator<Integer> iterator2 = keySet2.iterator();
        List<Integer> keyList2 = new ArrayList<Integer>();
        while (iterator2.hasNext()) {
            keyList2.add(iterator2.next());
        }
        assertEquals(keyList2.size(), 15);

        for (int i = 1; i <= 15; i++) {
            assertTrue(keyList2.contains(i));
        }
    }

    @Test
    public void testPut() throws Exception {

        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<Integer, String>();
        assertNull(testMap.put(5, "cinco"));
        assertNull(testMap.put(6, "seis"));
        assertEquals(testMap.size(), 2);

    }

    @Test
    public void testRemove() throws Exception {
        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<Integer, String>();
        assertNull(testMap.remove(6));
    }

    @Test
    public void testEntrySet() throws Exception {
        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<Integer, String>();
        Iterable<Entry<Integer, String>> entrySet = testMap.entries();
        Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
        List<Entry<Integer, String>> entryList = new ArrayList<Entry<Integer, String>>();
        while (iterator.hasNext()) {
            entryList.add(iterator.next());
        }
        assertEquals(entryList.size(), 0);
    }

    @Test
    public void testValues() throws Exception {
        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<Integer, String>();
        Iterable<String> values = testMap.values();
        Iterator<String> iterator = values.iterator();
        List<String> valuesList = new ArrayList<String>();
        while (iterator.hasNext()) {
            valuesList.add(iterator.next());
        }
        assertEquals(valuesList.size(), 0);
    }

    @Test
    public void insertMany() {
        HashTableMapSC<Integer, String> testMap = new HashTableMapSC<Integer, String>();
        int ammountOfEntriesInserted = 100;
        for (int i = 0; i < ammountOfEntriesInserted; i++) {
            testMap.put(i, "valor " + i);
        }
        assertEquals(testMap.size(), ammountOfEntriesInserted);
    }

    @Test
    public void testRehash() {
        HashTableMapSC<Integer, Integer> listin1 = new HashTableMapSC<Integer, Integer>(10);

        final int NUM_ENTRIES = 1000;

        // Testing size
        for (int cont = 0; cont < NUM_ENTRIES; cont++) {
            listin1.put(cont, cont);
        }
        assertEquals(listin1.size(), NUM_ENTRIES);

        // Testing elements
        listin1 = new HashTableMapSC<Integer, Integer>(10);
        int cont2, cont;
        for (cont = 1; cont <= NUM_ENTRIES; cont++) {
            listin1.put(cont, cont);
            cont2 = 1;
            while ((listin1.get(cont2) != null) && (cont2 <= cont)) {
                cont2++;
            }
            assertEquals(cont2, cont + 1);
        }
    }
}
