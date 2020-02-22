
/**
 * Write a description of class Demonstration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demonstration
{
       
    public Demonstration()
    {
        
    }

     
    public static void main(String[] args){
        Rational test = new Rational();
        Rational test2 = new Rational();
        
        test.setNumerator();
        test.setDenominator();
        System.out.print("Here is your rational printed using its very own printRational() method: ");
        Rational.printRational(test);
        System.out.println("Here is the rational as a decimal: " + test.toDouble() + ".");
        System.out.println("Time to test our negate method");
        System.out.println("Our rational negated is: " + test.negate());
        System.out.println("Time to test our invert method");
        System.out.println("The inverse of our rational is: " + test.invert());
        System.out.println("Time to test our greatest common divisor method");
        System.out.println("Our greatest common divisor of our numerator, " + test.getNumerator() + " and our denominator, " + test.getDenominator() + " is: " + test.greatestCommonDivisor());
        System.out.println("Time to test our multiply, divide, add and subtract methods. Please choose another rational for our tests: ");
        test2.setNumerator();
        test2.setDenominator();
        System.out.println("The product of our two rationals is: " + test.multiply(test2));
        System.out.println("The quotient of our two rationals is: " + test.divide(test2));
        System.out.println("Our two rationals added together is: " + test.add(test2));
        System.out.println("The difference between our two rationals is: " + test.subtract(test2));
        System.out.println("And finally a test of our reduction and equals");
        System.out.println("Choose two wholly new rationals to compare. And please make one of them able to be reduced");
        test.setNumerator();
        test.setDenominator();
        test2.setNumerator();
        test2.setDenominator();
        if (test.equals(test2)){
            System.out.println(test.toString() + " does equal " + test2.toString());
        }
            else 
            System.out.println(test.toString() + " does not equal " + test2.toString());
        System.out.println("The first rational reduced is " + Rational.toString(test.reduce()));
        
        System.out.println("The second rational reduced is " + Rational.toString(test2.reduce()));
            
        
    }
}
