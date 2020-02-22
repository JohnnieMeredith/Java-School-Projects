

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RationalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RationalTest
{
    /**
     * Default constructor for test class RationalTest
     */
    public RationalTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TestRational()
    {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(2,1);
    }
    public void TestRationalZero()
    {
        Rational rational1 = new Rational(0, 2);
        Rational rational2 = new Rational(2,0);
    }
    @Test
    public void TestPrintandtoString()
    {
        Rational rational1 = new Rational(02, 2);
        Rational.printRational(new Rational(0,02));
    }

    @Test
    public void TestAdd()
    {
         new Rational(2,1).equals(Rational.add( new Rational(0,2), new Rational(2,1)));
    }
    @Test
    public void TestAddZero()
    {
         new Rational(0,1).equals(Rational.add( new Rational(0,2), new Rational(0,1)));
    }
    @Test
    public void TestNegative()
    {
         new Rational(-2,1).equals(Rational.add( new Rational(0,2), new Rational(-2,1)));
    }
    

    @Test
    public void TestSubtract()
    {
        assertEquals("1/1", Rational.toString(Rational.subtract(new Rational(15,10), new Rational(1,2))));
    }
    @Test
    public void TestSubtractZero()
    {
        assertEquals("0/1", Rational.toString(Rational.subtract(new Rational(5,10), new Rational(1,2))));
    }
    @Test
    public void TestSubtractNegative()
    {
        assertEquals("-1/2", Rational.toString(Rational.subtract(new Rational(0,10), new Rational(1,2))));
    }
    @Test
    public void TestDivide()
    {
        assertEquals("1/1", Rational.toString(Rational.divide(new Rational(1,2), new Rational(1,2))));
    }
    @Test
    public void TestDivideZero()
    {
        assertEquals("0/1", Rational.toString(Rational.divide(new Rational(1,2), new Rational(0,2))));
        assertEquals("0/1", Rational.toString(Rational.divide(new Rational(0,2), new Rational(1,2))));
    }
    @Test
    public void TestDivideNegative()
    {
        assertEquals("-1/1", Rational.toString(Rational.divide(new Rational(1,2), new Rational(-1,2))));
    }
    @Test
    public void TestMultiply()
    {
        assertEquals("1/4", Rational.toString(Rational.multiply(new Rational(1,2), new Rational(1,2))));
    }
    @Test
    public void TestMultiplyZero()
    {
        assertEquals("0/1", Rational.toString(Rational.multiply(new Rational(1,2), new Rational(0,2))));
        assertEquals("0/1", Rational.toString(Rational.multiply(new Rational(0,2), new Rational(1,2))));
    }
    @Test
    public void TestMultiplyNegative()
    {
        assertEquals("1/-4", Rational.toString(Rational.multiply(new Rational(1,2), new Rational(-1,2))));
        assertEquals("1/-4", Rational.toString(Rational.multiply(new Rational(1,2), new Rational(1,-2))));
    }
    

    @Test
    public void TestInvert()
    {
        assertEquals("1/3", Rational.toString(Rational.invert(new Rational(3,1))));
    }
    @Test
    public void TestInvertNegative()
    {
        assertEquals("1/-3", Rational.toString(Rational.invert(new Rational(-3,1))));
    }
    @Test
    public void TestInvertZero()
    {
        System.out.println("Choose 1 as your new denominator to pass test");
        assertEquals("1/0", Rational.toString(Rational.invert(new Rational(0,1))));
    }
    

    @Test
    public void TestReduce()
    {
        assertEquals("1/3", Rational.toString(Rational.reduce(new Rational(3,9))));
    }
    @Test
    public void TestReduceZero()
    {
        assertEquals("0/1", Rational.toString(Rational.reduce(new Rational(0,9))));
    }
    @Test
    public void TestReduceNegative()
    {
        assertEquals("1/-3", Rational.toString(Rational.reduce(new Rational(-3,9))));
    }

    

    @Test
    public void compareTo()
    {
        Rational rational1 = new Rational(4, 5);
        assertEquals(0, rational1.compareTo(new Rational(4,5)));
        assertEquals(1, rational1.compareTo(new Rational(3,5)));
        assertEquals(-1, rational1.compareTo(new Rational(1,1)));
    }
}










