
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import student.TestCase;

/**
 * test class
 * 
 * @author omaralshikh, ahmadmalik
 * @version 7/10/2020
 */
public class BigNumArithmeticTest extends TestCase {

    private BigNumArithmetic b;
    private final ByteArrayOutputStream outContent =
        new ByteArrayOutputStream();


    /**
     * set up method to test class
     */
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }


    /**
     * tests inside the main method
     * 
     * @throws FileNotFoundException
     *             thrown if file cannot be found
     */
    public void testMain() throws FileNotFoundException {
        String[] args2 = { null };

        b.main(args2);
        assertEquals("No Argument Given\n", outContent.toString());
        outContent.reset();

        String[] args = { "test1.txt" };

        b.main(args);
        assertEquals("56669777 99999911111 + 352324012 + 3 ^ 555557778 * = "
            + "562400792227677956625810678708149922000000\n", outContent
                .toString());
        outContent.reset();
    }


    /**
     * tests the reaf file method
     * 
     * @throws FileNotFoundException
     *             thrown if file is not found
     */
    @SuppressWarnings("static-access")
    public void testReadFile() throws FileNotFoundException {

        b.readFile("test2.txt");
        assertEquals("99999999 990001 * 1119111 55565 33333 + * + 88888888 + = "
            + "99099674628565\n", outContent.toString());
        outContent.reset();

        b.readFile("test3.txt");
        assertEquals(
            "123456789 1111111111 * 111119 2111111 9111111 * + * 1 ^ = "
                + "2638486500477638652325851269760\n", outContent.toString());
        outContent.reset();

        b.readFile("test4.txt");
        assertEquals("9 1 + 5 * 0 + = 50\n", outContent.toString());
        outContent.reset();

        b.readFile("test5.txt");
        assertEquals("999999999 0 * = 0\n", outContent.toString());
        outContent.reset();

        b.readFile("test6.txt");
        assertEquals("9 0 ^ = 1\n", outContent.toString());
        outContent.reset();

        b.readFile("test7.txt");
        assertEquals("5555555 333333 5454353 999999 666666 1 ^ * * + = \n",
            outContent.toString());
        outContent.reset();

        b.readFile("test8.txt");
        assertEquals("3432 3333 9999 + * ^ * * 6666 + = \n", outContent
            .toString());
        outContent.reset();

        b.readFile("test9.txt");
        assertEquals("", outContent.toString());
        outContent.reset();

        b.readFile("test10.txt");
        assertEquals("10 + = \n", outContent.toString());
        outContent.reset();

        b.readFile("test11.txt");
        assertEquals("56669777 99999911111 + 352324012 + 3 ^ 555557778 * ="
            + " 562400792227677956625810678708149922000000\n99999999 990001 * "
            + "1119111 55565 33333 + * + 88888888 + = 99099674628565\n",
            outContent.toString());
        outContent.reset();

        b.readFile("test12.txt");
        assertEquals("+ = \n+ = \n20 50 + = 70\n20 50 + = 70\nabc abs = \n",
            outContent.toString());
        outContent.reset();
    }

}
