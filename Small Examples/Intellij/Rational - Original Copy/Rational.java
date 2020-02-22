import java.util.*;
/**
 * Write a description of class Rational here.
 *
 * @author Johnnie Meredith
 * @version 1.0 setpember 20 2018 1125am
 */
public class Rational
{
    // instance variables - replace the example below with your own

    int denTemp;
    int numTemp;
    int numgcd;
    int dengcd;
    int gcd;
    static int staticDenTemp;
    static int staticNumTemp;
    static int staticgcd;
    static int staticNumgcd;
    static int staticDengcd;
    private int numerator;
    private int denominator;
    double rationalTemp;

    /**
     * Constructor objects of class Rational
     * First takes two integers as arguments
     * Second allows setting of numerator and denominator via methods
     */

    public Rational(){

    }
    
    public Rational (int numerator, int denominator){
        setNumerator(numerator);
        try{
            setDenominator(denominator);
            denTemp = 1/this.denominator;
        }
        catch (Exception e) {  
            System.err.println("You are not supposed to divide by zero.");
            setDenominator();
        }
    }

    /**
     * GET and SET methods
     */
    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public void setNumerator(int n){
        this.numerator = n;
    }

    public void setNumerator(){
        System.out.println("Choose a numerator for your fraction.");
        Scanner get = new Scanner(System.in);
        this.numerator = get.nextInt();

    }

    public void setDenominator(int d){
        this.denominator = d;
    }

    public void setDenominator(){
        try {
            System.out.println("Choose a denominator for your fraction.");
            Scanner get = new Scanner(System.in);
            this.denominator = get.nextInt();
            denTemp = 1/this.denominator;

        } catch (Exception e) {
            System.err.println("You are not supposed to divide by zero.");
            setDenominator();
        }

    }

    /**
     * REDUCE methods overloaded
     * one static and two non-static implementations all with different passed parameters
     * First takes a Rational as a parameter
     * Second takes two integers as parameters for numerator and denominator
     * Third allows you to act on the instance of the parameter itself
     */

    public static Rational reduce(Rational r){
        staticNumTemp = r.getNumerator();
        staticDenTemp = r.getDenominator();

        staticgcd = greatestCommonDivisor(staticNumTemp, staticDenTemp);
        staticNumgcd = staticNumTemp/staticgcd;
        staticDengcd = staticDenTemp/staticgcd;
        Rational reduce = new Rational(staticNumgcd, staticDengcd);
        return reduce;

    }

    
    public Rational reduce(int numer, int denom){
        gcd = greatestCommonDivisor(numer, denom);
        numgcd = numer/gcd;
        dengcd = denom/gcd;
        Rational reduce = new Rational(numgcd, dengcd);
        return reduce;
    }

    public Rational reduce(){
        gcd = greatestCommonDivisor(this.numerator, this.denominator);
        numgcd = this.numerator/gcd;
        dengcd = this.denominator/gcd;
        Rational reduce = new Rational(numgcd, dengcd);
        return reduce;
    }

    /**
     * TODOUBLE methods overloaded
     * First takes a rational as a parameter and returns it as a double
     * Second takes two integers(numerator and denominator) and returns their quotient
     * Third allows you to return the double value of a Rational object itself
     */

    public double toDouble(Rational r){
        rationalTemp = 1.0 * r.getNumerator()/r.getDenominator();
        return rationalTemp;
    }

    public double toDouble(int numerator, int denominator){
        rationalTemp = 1.0 * numerator/denominator;
        return rationalTemp;
    }

    public double toDouble(){
        rationalTemp = 1.0 * this.numerator/this.denominator;
        return rationalTemp;
    }

    /**
     * TOSTRING methods overloaded
     * First takes a Rational as a parameter and returns it as a String
     * Second takes two integers(numerator and denominator) and returns it as a String
     * Third converts a Rational object itself to a String
     */
    public static String toString(Rational r){
        String stringRational;
        staticDenTemp = r.getDenominator();
        staticNumTemp = r.getNumerator();
        stringRational = Integer.toString(staticNumTemp) + "/" + Integer.toString(staticDenTemp);
        return stringRational;

    }

    public static String toString(int numerator, int denominator){
        String s;
        s = numerator + "/" + denominator;
        return s;
    }

    public String toString(){
        String s;
        s = this.numerator + "/" + this.denominator;
        return s;
    }

    /**
     * PRINTRATIONAL overloaded
     * Takes a Rational object as a parameter and prints it to console by converting it to a String
     * First takes a Rational as a parameter and outputs it to console by coverting it to a String an printing it
     * Second prints the current Rational object by converting to a String and printing it
     */
    public static void printRational(Rational r){

        //System.out.println(Rational.toString(r));
        //System.out.println(Rational.toString(r.getNumerator(), r.getDenominator()));
        System.out.println(r.toString());
    }

    public void printRational(){
        //System.out.println(Rational.toString(this));      
        //System.out.println(Rational.toString(this.getNumerator(), this.getDenominator()));
        System.out.println(this.toString());
    }

    /**
     * NEGATE method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public Rational negate(Rational r){
        numTemp = r.getNumerator();
        denTemp = r.getDenominator();
        Rational rTemp = new Rational((-1 * numTemp), denTemp);
        return rTemp;
    }

    public Rational negate(int numerator, int denominator){
        Rational r = new Rational((-1 * numerator), denominator);
        return r;
    }

    public Rational negate(){
        numTemp = this.numerator;
        denTemp = this.denominator;
        Rational r = new Rational((-1 * numTemp), denTemp);
        return r;
    }

    /**
     * INVERT method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public Rational invert(int numerator, int denominator){
        try{
        int x = denominator/numerator;
        Rational r = new Rational(denominator, numerator);
        return r;
    }
    catch(Exception e){
        System.out.println("That would cause a divide by zero if inverted");
        return new Rational();
    }
    }

    public static Rational invert(Rational r){
        try{
        int x = r.getDenominator()/r.getNumerator();
            Rational rTemp = new Rational(r.getDenominator(), r.getNumerator());
        return rTemp;
    }
    catch(Exception e){
          System.out.println("That would cause a divide by zero if inverted");
          return new Rational();
    }
    }

    public Rational invert(){
        try{
        int x = this.denominator/this.numerator;
            Rational rTemp = new Rational(this.denominator, this.numerator);
        return rTemp;
    }
        catch(Exception e){
              System.out.println("That would cause a divide by zero if inverted.");
              return new Rational();
    }
    }

    /**
     * GREATESTCOMMONDIVISOR method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public static int greatestCommonDivisor(Rational rTemp){
        staticDenTemp = rTemp.getDenominator();
        staticNumTemp = rTemp.getDenominator();
        if (staticDenTemp!=0){
            return greatestCommonDivisor(staticNumTemp, staticDenTemp);
        }
        else
            return 0;

    }

    public static int greatestCommonDivisor(int numerator, int denominator){

        if (denominator == 0){
            return numerator;
        }
        else
            return greatestCommonDivisor(denominator, numerator%denominator);
    }


    public int greatestCommonDivisor(){

        if (denominator == 0){
            return numerator;
        }
        else
            return greatestCommonDivisor(denominator, numerator%denominator);
    }

    /**
     * MULTIPLY method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public static Rational multiply(Rational r, Rational p){
        try{
        int numTemp = r.getNumerator() * p.getNumerator();
        int denTemp = r.getDenominator() * p.getDenominator();
        Rational rTemp = new Rational(numTemp, denTemp);
        return rTemp.reduce();
    }
    catch(Exception e){
        System.out.println("This multiplication would cause division by zero");
        return new Rational();
    }
    }


    public Rational multiply(int num1, int denom1, int num2, int denom2){
        try{
        numTemp = num1 * num2;
        denTemp = denom1 * denom2;
        Rational rTemp = new Rational(numTemp, denTemp);
        return rTemp.reduce(0,1);
    }
    catch(Exception e){
        System.out.println("This multiplication would cause division by zero");
        return new Rational(0,1);
    }
    }

    public Rational multiply(Rational r){
        
        numTemp = this.numerator * r.getNumerator();
        denTemp = this.denominator * r.getDenominator();
        Rational rTemp = new Rational(numTemp, denTemp);
        return rTemp.reduce();
    
    
    }

    /**
     * DIVIDE method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public static Rational divide(Rational r, Rational p){
        try{
            
            staticNumTemp = r.getNumerator() * p.getDenominator();
            staticDenTemp = p.getNumerator() * r.getDenominator();
            int x = staticNumTemp/staticDenTemp;
            Rational rTemp = new Rational(staticNumTemp, staticDenTemp);
            return rTemp.reduce();
        }
        catch  (Exception e){
            Rational rTemp = new Rational(0, 1);
            return rTemp.reduce();

        }

    }

    public Rational divide(int num1, int denom1, int num2, int denom2){
        try{
            numTemp = num1 * denom2;
            denTemp = denom1 * num2;
            int x = numTemp/denTemp;
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce();
        }
        catch (Exception e){
            Rational rTemp = new Rational(0, 1);
            return rTemp.reduce();

        }
    }

    public Rational divide(Rational r){
        try{
            numTemp = this.numerator * r.getDenominator();
            denTemp = this.denominator * r.getNumerator();
            int x = numTemp/denTemp;
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce();
        }
        catch (Exception e){
            Rational rTemp = new Rational(0, 1);
            return rTemp.reduce();

        }
    }

    /**
     * ADD method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public static Rational add(Rational r, Rational p){
        if(p.getNumerator() == 0){
            return r;
        }
        if(r.getNumerator()==0){
            return p;
        }
        else{
            int numTemp = (r.getNumerator() *  p.getDenominator()) + (p.getNumerator() * r.getDenominator());
            int denTemp = (r.getDenominator() * p.getDenominator());
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce();  
        }
    }

    public Rational add(int num1, int denom1, int num2, int denom2){
        if(num1 == 0){
            return new Rational(num2, denom2);
        }
        if(num2 == 0){
            return new Rational(num1, denom1);
        }
        else {
            numTemp = (num1 *  denom2) + (num2 * denom1);
            denTemp = (denom1 * denom2);
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce(); 
        }
    }

    public Rational add(Rational r){
        if(r.getNumerator() == 0){
            return new Rational(this.getNumerator(), this.getDenominator());
        }
        if(this.getNumerator() == 0){
            return r.reduce();
        }
        numTemp = (r.getNumerator() *  this.getDenominator()) + (this.getNumerator() * r.getDenominator());
        denTemp = (r.getDenominator() * this.getDenominator());
        Rational rTemp = new Rational(numTemp, denTemp);
        return rTemp.reduce();    
    }

    /**
     * SUBTRACT method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public static Rational subtract(Rational r, Rational p){
        if(p.getNumerator() == 0){
            return r.reduce();
        }
        if(r.getNumerator()==0){
            return Rational.reduce(p.negate());
        }
        else{
            int numTemp = (r.getNumerator() *  p.getDenominator()) - (p.getNumerator() * r.getDenominator());
            int denTemp = (r.getDenominator() * p.getDenominator());
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce();
        }
    }

    public Rational subtract(int num1, int denom1, int num2, int denom2){
        if(num1 == 0){
            return new Rational(-num2, denom2).reduce();
        }
        if(num2 == 0){
            return new Rational(num1, denom1).reduce();
        }
        else {
            numTemp = (num1 *  denom2) - (num2 * denom1);
            denTemp = (denom1 * denom2);
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce(); 
        }
    }

    public Rational subtract(Rational r){
        if (r.getNumerator() == this.getNumerator()){
            Rational rTemp = new Rational(0,1);
            return rTemp.reduce();
        }
        if(r.getNumerator() == 0){
            return new Rational(this.getNumerator(), this.getDenominator());
        }
        if(this.getNumerator() == 0){
            return Rational.reduce(r.negate());
        }
        else{
            numTemp = (r.getNumerator() *  this.getDenominator()) - (this.getNumerator() * r.getDenominator());
            denTemp = (r.getDenominator() * this.getDenominator());
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce(); 
        }
    }

    /**
     * EQUALS method overloaded
     * First takes two rationals as paramaters and compares the second to the first
     * Second takes a second Rational as a parameter and compares it to the current Rational object itself
     * Both will return true if they are equal to each other
     */
    public boolean equals(Rational r, Rational p){
        if(r.toDouble() == p.toDouble()){
            return true;
        }
        else
            return false;
    }

    public boolean equals(Rational r){
        if(r.toDouble() == this.toDouble()){
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args){
        Rational test = new Rational();

    }
}
 