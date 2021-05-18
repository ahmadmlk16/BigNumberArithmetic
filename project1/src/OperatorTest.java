import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Before;
import student.TestCase;

/**
 * test class
 * 
 * @author omaralshikh, ahmadmalik
 * @version 7/10/2020
 */
public class OperatorTest extends TestCase {

    private Operator n;
    private LinkedList<Integer> arith;
    private LinkedList<Integer> arith2;
    private LinkedList<Integer> arith3;
    private LinkedList<Integer> arith4;
    private LinkedList<Integer> arith5;
    private LinkedList<Integer> arith6;
    private LinkedList<Integer> arith7;
    private LinkedList<Integer> arith8;
    private LinkedList<Integer> arith9;
    private LinkedList<Integer> arith10;
    private final ByteArrayOutputStream outContent =
        new ByteArrayOutputStream();


    /**
     * setup method
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // initialzie field
        arith = new LinkedList<Integer>();
        arith2 = new LinkedList<Integer>();
        arith3 = new LinkedList<Integer>();
        arith4 = new LinkedList<Integer>();
        arith5 = new LinkedList<Integer>();
        arith6 = new LinkedList<Integer>();
        arith7 = new LinkedList<Integer>();
        arith8 = new LinkedList<Integer>();
        arith9 = new LinkedList<Integer>();
        arith10 = new LinkedList<Integer>();
        System.setOut(new PrintStream(outContent));
        n = new Operator();
    }


    /**
     * tests multiplication method
     */
    @SuppressWarnings("static-access")
    public void testMulti() {
        arith.add(1);
        arith.add(1);

        arith2.add(2);
        arith2.add(1);

        LinkedList<Integer> result;
        LinkedList<Integer> result2;

        result = new LinkedList<Integer>();
        result2 = new LinkedList<Integer>();
        LinkedList<Integer> result3;

        result3 = new LinkedList<Integer>();
        result.add(2);
        result.add(3);
        result.add(1);
        assertEquals(result, n.multi(arith, arith2));

        arith3.add(4);
        arith3.add(8);
        arith3.add(1);
        arith3.add(7);
        arith3.add(2);

        arith4.add(6);
        arith4.add(7);
        arith4.add(3);

        result2.add(4);
        result2.add(8);
        result2.add(1);
        result2.add(1);
        result2.add(2);
        result2.add(2);
        result2.add(0);
        result2.add(1);

        assertEquals(result2, n.multi(arith3, arith4));

        arith5.add(7);
        arith6.add(0);
        arith6.add(1);
        result3.add(0);
        result3.add(7);

        assertEquals(result3, n.multi(arith5, arith6));

    } // end testMulti


    /**
     * tests Addition method
     */
    @SuppressWarnings("static-access")
    public void testAddition() {
        arith.add(1);
        arith.add(1);
        arith2.add(2);
        arith2.add(1);
        LinkedList<Integer> result;
        LinkedList<Integer> result2;
        LinkedList<Integer> result3;
        LinkedList<Integer> result4;
        LinkedList<Integer> result5;
        LinkedList<Integer> result6;
        LinkedList<Integer> result7;
        LinkedList<Integer> result8;

        result8 = new LinkedList<Integer>();

        result5 = new LinkedList<Integer>();
        result6 = new LinkedList<Integer>();
        result7 = new LinkedList<Integer>();

        result = new LinkedList<Integer>();
        result.add(3);
        result.add(2);
        assertEquals(result, n.addition(arith, arith2));
        result2 = new LinkedList<Integer>();

        arith3.add(1);
        arith3.add(2);
        arith3.add(6);
        arith3.add(1);
        arith4.add(9);
        arith4.add(9);
        arith4.add(9);
        result2.add(0);
        result2.add(2);
        result2.add(6);
        result2.add(2);
        assertEquals(result2, n.addition(arith3, arith4));
        result3 = new LinkedList<Integer>();
        arith5.add(1);
        arith5.add(2);
        arith5.add(6);
        arith5.add(1);
        arith6.add(9);
        arith6.add(9);
        arith6.add(9);
        arith6.add(9);
        result3.add(0);
        result3.add(2);
        result3.add(6);
        result3.add(1);
        result3.add(1);
        assertEquals(result3, n.addition(arith5, arith6));
        result4 = new LinkedList<Integer>();
        arith7.add(9);
        arith7.add(9);
        arith7.add(9);
        arith7.add(9);
        arith8.add(1);
        arith8.add(2);
        arith8.add(6);

        result4.add(0);
        result4.add(2);
        result4.add(6);
        result4.add(0);
        result4.add(1);

        assertEquals(result4, n.addition(arith7, arith8));

        arith9.add(7);
        arith10.add(5);
        arith10.add(9);
        result5.add(2);
        result5.add(0);
        result5.add(1);

        assertEquals(result5, n.addition(arith9, arith10));

        LinkedList<Integer> arith11;
        LinkedList<Integer> arith12;
        arith11 = new LinkedList<Integer>();
        arith12 = new LinkedList<Integer>();
        LinkedList<Integer> arith13;
        LinkedList<Integer> arith14;
        arith13 = new LinkedList<Integer>();
        arith14 = new LinkedList<Integer>();
        LinkedList<Integer> arith15;
        LinkedList<Integer> arith16;
        arith15 = new LinkedList<Integer>();
        arith16 = new LinkedList<Integer>();

        arith11.add(9);
        arith11.add(9);
        arith11.add(9);
        arith11.add(9);
        arith11.add(9);

        arith12.add(9);

        result6.add(8);
        result6.add(0);
        result6.add(0);
        result6.add(0);
        result6.add(0);
        result6.add(1);

        assertEquals(result6, n.addition(arith12, arith11));

        arith13.add(1);
        arith13.add(1);
        arith13.add(1);
        arith13.add(1);
        arith13.add(1);

        arith14.add(1);
        result7.add(2);
        result7.add(1);
        result7.add(1);
        result7.add(1);
        result7.add(1);

        assertEquals(result7, n.addition(arith14, arith13));

        arith16.add(9);
        arith16.add(9);
        arith16.add(9);
        arith16.add(9);
        arith16.add(9);

        arith15.add(9);

        result8.add(8);
        result8.add(0);
        result8.add(0);
        result8.add(0);
        result8.add(0);
        result8.add(1);

        assertEquals(result8, n.addition(arith16, arith15));

    } // end testAddition


    /**
     * tests Exponent method
     */
    @SuppressWarnings("static-access")
    public void testExpo() {
        LinkedList<Integer> result;
        result = new LinkedList<Integer>();
        LinkedList<Integer> result2;
        result2 = new LinkedList<Integer>();
        LinkedList<Integer> result3;
        result3 = new LinkedList<Integer>();
        LinkedList<Integer> result4;
        result4 = new LinkedList<Integer>();
        LinkedList<Integer> result5;
        result5 = new LinkedList<Integer>();
        // 2 case
        arith.add(2);
        arith.add(1);
        arith2.add(2);

        result.add(4);
        result.add(4);
        result.add(1);

        assertEquals(result, n.exp(arith, arith2));

        // 0 case
        arith3.add(2);
        arith3.add(2);
        arith4.add(0);
        result2.add(1);

        assertEquals(result2, n.exp(arith3, arith4));

        // 1 case
        arith5.add(2);
        arith5.add(2);
        arith6.add(1);
        result3.add(2);
        result3.add(2);

        assertEquals(result3, n.exp(arith5, arith6));

        // even case
        arith7.add(2);
        arith8.add(8);
        result4.add(6);
        result4.add(5);
        result4.add(2);

        assertEquals(result4, n.exp(arith7, arith8));

        // odd case

        arith9.add(2);
        arith10.add(5);
        result5.add(2);
        result5.add(3);

        assertEquals(result5, n.exp(arith9, arith10));

    } // end testExpo


    /**
     * tests the TOInt method
     */
    @SuppressWarnings("static-access")
    public void testToInt() {
        Integer[] array = { 0 };
        assertEquals(0, n.toInt(array));

        Integer[] array2 = { 0, 1 };
        assertEquals(1, n.toInt(array2));

    } // end testToInt


    /**
     * tests the spilt and print method
     * 
     * @throws IOException
     */
    public void testSplitAndPrint() throws IOException {
        n.splitAndPrint("001 002 003 2202 555000 0000210 000");
        assertEquals("1 2 3 2202 555000 210 0 ", outContent.toString());
        outContent.reset();

        n.splitAndPrint("120000000010 000000000000000 5265");
        assertEquals("120000000010 0 5265 ", outContent.toString());
        outContent.reset();

        n.splitAndPrint("5 0");
        assertEquals("5 0 ", outContent.toString());
        outContent.reset();

        n.splitAndPrint("5 000 25");
        assertEquals("5 0 25 ", outContent.toString());
        outContent.reset();

        n.splitAndPrint("1000000001");
        assertEquals("1000000001 ", outContent.toString());
        outContent.reset();

        n.splitAndPrint("");
        assertEquals(" ", outContent.toString());
        outContent.reset();
    }

} // end class
