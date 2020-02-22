

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FractionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FractionTest
{
    /**
     * Default constructor for test class FractionTest
     */
    public FractionTest()
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
    public void Test()
    {
        Fraction fraction1 = new Fraction(4, 5);
        assertEquals(.5, fraction1.toDouble(), 0.1);
    }

    @Test
    public void divideBy0()
    {
        Fraction fraction1 = new Fraction(5, 0);
        assertEquals(0, fraction1.toDouble(), 0.1);
        Fraction fraction2 = new Fraction(0, 5);
        assertEquals(0, fraction2.toDouble(), 0.1);
    }

    @Test
    public void TestPass()
    {
        Fraction fraction1 = new Fraction(1, 1);
        assertEquals(0, fraction1.toDouble(), 0.1);
    }
}



