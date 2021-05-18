
import java.util.Arrays;
import student.TestCase;

/**
 * 
 * class that tests the Linked List implementation
 * 
 * @author omaralshikh, ahmad malik
 * @version 7/8/2020
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> emptyListA;
    private LinkedList<String> emptyListB;
    private LinkedList<String> smallListA;
    private LinkedList<String> smallListB;
    private LinkedList<String> bigListA;
    private LinkedList<String> bigListB;
    private String nullObject;


    /**
     * Initializes 2 empty lists, 2
     * lists with a small number of items, and 2 lists
     * with a large number of items
     */
    public void setUp() {
        emptyListA = new LinkedList<String>();
        emptyListB = new LinkedList<String>();

        smallListA = new LinkedList<String>();
        smallListB = new LinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new LinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new LinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));

    }


    /**
     * Tests the equals method on a list
     * with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        // smallListA.remove("rope jumping");
        // smallListA.add("jump roping");
        // assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a
     * list with a large number of items in it
     */
    public void testEqualsBigList() {
        LinkedList<String> bigListC;
        LinkedList<String> bigListD;
        LinkedList<String> bigListE;
        bigListC = new LinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListC.add("sport" + i);
        }
        bigListD = new LinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListD.add("sport" + i);
        }
        bigListE = new LinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListE.add("sport" + i);
        }
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed

        for (int i = 100; i > 0; i--) {
            bigListC.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups

        for (int i = 0; i < 50; i++) {
            bigListD.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListD.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListD));

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }


    /**
     * njn
     */
    public void testSize() {
        assertEquals(0, emptyListA.size());
        assertEquals(0, emptyListB.size());

        emptyListA.add("s");
        emptyListB.add("b");
        assertEquals(1, emptyListA.size());
        assertEquals(1, emptyListB.size());

        assertEquals(3, smallListA.size());
        assertEquals(3, smallListB.size());

    }


    /**
     * nn
     */
    public void testAdd() {

        assertEquals(0, emptyListA.size());
        assertEquals(0, emptyListB.size());

        emptyListA.add("s");
        emptyListB.add("b");
        assertEquals(1, emptyListA.size());
        assertEquals(1, emptyListB.size());

        bigListA.add("apt");
        assertEquals(101, bigListA.size());
        Exception thrown = null;

        try {
            emptyListA.add(null);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

    }


    /**
     * kj
     */
    public void testIsEmpty() {
        assertTrue(emptyListA.isEmpty());
        assertTrue(emptyListB.isEmpty());
        assertFalse(smallListA.isEmpty());
        assertFalse(smallListB.isEmpty());
        emptyListA.add("s");
        emptyListB.add("b");
        assertFalse(emptyListA.isEmpty());
        assertFalse(emptyListB.isEmpty());

    }


    /**
     * jnj
     */
    public void testGet() {
        assertEquals("soccer", smallListA.get(0));
        assertEquals("swimming", smallListA.get(1));
        assertEquals("gymnastics", smallListA.get(2));
        assertEquals("soccer", smallListB.get(0));
        assertEquals("swimming", smallListB.get(1));
        assertEquals("gymnastics", smallListB.get(2));

    }


    /**
     * uh
     */
    public void testContains() {
        String anEntry = "sock";
        assertFalse(smallListA.contains(anEntry));
        smallListA.add(anEntry);
        assertTrue(smallListA.contains(anEntry));
        String anEntry2;
        anEntry2 = "w";
        smallListA.add(anEntry2);
        assertTrue(smallListA.contains(anEntry2));

    }


    /**
     * uihji
     */
    public void testLastIndexOf() {
        assertEquals(0, smallListA.lastIndexOf("soccer"));
        assertEquals(1, smallListA.lastIndexOf("swimming"));
        assertEquals(2, smallListA.lastIndexOf("gymnastics"));
        assertEquals(0, smallListB.lastIndexOf("soccer"));
        assertEquals(1, smallListB.lastIndexOf("swimming"));
        assertEquals(2, smallListB.lastIndexOf("gymnastics"));

    }


    /**
     * jnn
     */
    public void testToString() {
        String anEntry = "tower";
        String anEntry2 = "hanoi";
        emptyListA.add(anEntry);
        assertEquals(1, emptyListA.size());
        assertEquals("{tower}", emptyListA.toString());
        emptyListA.add(anEntry2);
        assertEquals("{tower, hanoi}", emptyListA.toString());

    }


    /**
     * tests getCopy
     */
    public void testGetCopy() {
        emptyListA.add("soccer");
        emptyListA.add("swimming");
        emptyListA.add("gymnastics");
        assertEquals(emptyListA, smallListA.getCopy());

    }

}
