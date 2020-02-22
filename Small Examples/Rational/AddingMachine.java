
import java.util.*;
import java.math.*;
/**
 * Write a description of class AddingMachine here.
 *
 * @author Johnnie Meredith
 * @version 0.1 September 26, 2018
 */
public class AddingMachine
{
    // instance variables - replace the example below with your own
    static Rational[] rationalArray = new Rational[10];
    static Rational[] tempRationalArray = new Rational[10];
    static double[] doubleArray = new double[0];
    static double dAverage;
    static double dMax;
    static double dMin;
    static double dStdDeviation;
    static Rational fAverage;
    static Rational fMax;
    static Rational fMin;
    static Rational fStdDeviation;
    static double stdDeviation;
    public AddingMachine()
    {

    }
    public double addDoubles(Rational[]r){
        double sum = 0;
        for(int x = 0; x < r.length; x++){
            sum += tempRationalArray[x].toDouble();
        }
        return sum;

    }

    public Rational addFractions(Rational[]r){
        Rational sum = new Rational(0,1);
        for(int x = 0; x < r.length; x++){
            sum = sum.add(tempRationalArray[x]);
        }
        return sum;

    }

    public static Rational[] sampleData(){
        for(int x = 0; x < 10; x++){
            tempRationalArray[x] = new Rational(x+1,1);
        }
        return tempRationalArray;
    }

    public static int randomInt() {
        Random random = new Random();
        return (random.nextInt(100)+1);
    }

    public static double getStdDeviation(Rational[] tempRationalArray){
        Rational tempAverage = average(tempRationalArray);
        Rational tempStdDev = new Rational(0,1);
        Rational tempRatVar = new Rational(0,1);

        for(int x = 0; x < tempRationalArray.length-1; x++){

            tempRatVar = (tempRationalArray[x].subtract(tempAverage).multiply(tempRationalArray[x].subtract(tempAverage))).reduce();

            
            tempStdDev = (tempStdDev.add(tempRatVar)).reduce();

        }
        tempStdDev = tempStdDev.divide(new Rational(10,1)).reduce();
        return Math.sqrt((tempStdDev.toDouble()));
    }

    public static double getStandardDeviation(Rational[] tempRationalArray){
        double avg = average(tempRationalArray).toDouble();
        for(int x = 0; x < tempRationalArray.length-1; x++){
            stdDeviation += (tempRationalArray[x].toDouble()-avg)*(tempRationalArray[x].toDouble()-avg);
        }
        stdDeviation = Math.sqrt((stdDeviation/10));
        return stdDeviation;
    }

    public static Rational[] randomArray(int size) {
        Rational[] tempRationalArray = new Rational[size];
        for (int i = 0; i < tempRationalArray.length; i++) {
            tempRationalArray[i] = new Rational(randomInt(),randomInt());
        }
        return tempRationalArray;
    }

    public static Rational minRational(Rational[] r){
        Rational min = new Rational(1000,1);
        for(int x = 0; x < r.length-1; x++){

            if (min.compareTo(r[x])==1){
                min.setNumerator(r[x].getNumerator());
                min.setDenominator(r[x].getDenominator());
            }
        }
        return min;
    }

    public static Rational maxRational(Rational[] r){
        Rational max = new Rational(1,1000);
        for(int x = 0; x < r.length-1; x++){
            if (max.compareTo(r[x])==-1){
                max.setNumerator(r[x].getNumerator());
                max.setDenominator(r[x].getDenominator());
            }
        }
        return max;
    }           

    public static Rational average(Rational[] r){
        Rational average = new Rational(0,1);
        for(int x = 0; x < r.length; x++){
            average = (average.add(r[x]));

        }

        return (average.divide(new Rational(r.length,1)).reduce());
    }

    public static double addArray(Rational[] rationalArray){
        double dTotal = 0; 
        for(int x = 0; x < rationalArray.length; x++){
            dTotal += (rationalArray[x].toDouble());

        }
        return dTotal;
    }

    public static double addArrayFraction(Rational[] rationalArray){
        Rational r = new Rational(0,1);    
        double dTotal = 0; 
        for(int x = 0; x < rationalArray.length; x++){
            r = r.add(rationalArray[x]);

        }
        dTotal = r.toDouble();
        return dTotal;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main()
    {

        rationalArray = randomArray(10);
        fAverage = average(rationalArray);
        fMax = maxRational(rationalArray);
        fMin = minRational(rationalArray);
        dStdDeviation = getStdDeviation(rationalArray);
        System.out.println("Fractions are " );
        for(int x = 0; x < rationalArray.length; x++){
            System.out.println((x+1) + ". " + rationalArray[x].toString());
        }
        System.out.println("The average as a fraction is " + fAverage);
        System.out.println("The minimum as a fraction is " + fMin);
        System.out.println("The maximum as a fraction is " + fMax);
        System.out.println("The standard deviation computed with fractions then converted to double is(Note: this seems to get too large for variables to hold often so it return NaN.) " 
            + dStdDeviation);
        double dString;
        dStdDeviation = getStandardDeviation(rationalArray);
        dMin = minRational(rationalArray).toDouble();
        dMax = maxRational(rationalArray).toDouble();
        dAverage = 0;
        System.out.println("Fractions as doubles are " );
        for(int x = 0; x < rationalArray.length; x++){
            dAverage += (rationalArray[x].toDouble());
            System.out.println((x+1) + ". " + Double.toString(rationalArray[x].toDouble()));
        }

        System.out.println("The average taken then converted to doubles is " + average(rationalArray).toDouble());
        System.out.println("The average converting to double and averaging after is " + dAverage/(rationalArray.length));
        System.out.println("The minimum as a double is " + dMin);
        System.out.println("The maximum as a double is " + dMax);
        System.out.println("The standard deviation computed with doubles is " + dStdDeviation);
        System.out.println("The total by converting each to double then adding is " + addArray(rationalArray));
        System.out.println("The total by adding fractions together and converting to doubles after is " + addArrayFraction(rationalArray));
        System.out.println("The difference between the two methods is " + Math.abs(addArray(rationalArray)-addArrayFraction(rationalArray)));

    }
}
