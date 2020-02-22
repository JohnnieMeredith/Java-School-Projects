
/**
 * Write a description of class Fraction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fraction
{
    int numerator;
    int denominator; 
    int fraction;
    public Fraction(int n, int d){
    numerator = n;
    denominator = d;
    }

    public double toDouble(){
        double temp = 0;
        if (numerator/denominator != 0){
            return numerator/denominator;
    }
    else 
    return 0;

}
}
