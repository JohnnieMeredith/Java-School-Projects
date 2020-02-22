import java.util.*;
/**
 * Write a description of class Rational here.
 *
 * @author Johnnie Meredith
 * @version 1.0 setpember 20 2018 1125am
 */
public class Rational
{
    // instance variables 

    long denTemp;
    long numTemp;
    long numgcd;
    long dengcd;
    long gcd;
    
    static long staticDenTemp;
    static long staticNumTemp;
    static long staticgcd;
    static long staticNumgcd;
    static long staticDengcd;
    
    private long numerator;
    private long denominator;
    
    double rationalTemp;
    String stringRational;
    
    /**
     * Constructor objects of class Rational
     * First takes two integers as arguments
     * Second allows setting of numerator and denominator via methods
     */

    
    
    public Rational (long numerator, long denominator){
        setNumerator(numerator);
         
            setDenominator(denominator);
            
        
           
        
    }
    public Rational(){
        setNumerator(0);
        setDenominator(0);

    }
    /**
     * GET and SET methods
     */
    public long getNumerator(){
        return this.numerator;
    }

    public long getDenominator(){
        return this.denominator;
    }

    public void setNumerator(long n){
        this.numerator = n;
    }

    public void setNumerator(){
        System.out.println("Choose a numerator for your fraction.");
        Scanner get = new Scanner(System.in);
        this.numerator = get.nextInt();
    }

    public void setDenominator(long d){
        
        this.denominator = d;
    }

    public void setDenominator(){
      
            System.out.println("Choose a denominator for your fraction.");
            Scanner get = new Scanner(System.in);
            this.denominator = get.nextInt();
            
        

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

    
    public Rational reduce(long numer, long denom){
        gcd = greatestCommonDivisor(numer, denom);
        numgcd = numer/gcd;
        dengcd = denom/gcd;
        Rational reduce = new Rational(numgcd, dengcd);
        return reduce;
    }

    public Rational reduce(){
        if((this.numerator != 0) && this.denominator != 0){
        gcd = greatestCommonDivisor(this.numerator, this.denominator);
        numgcd = this.numerator/gcd;
        dengcd = this.denominator/gcd;
        Rational reduce = new Rational(numgcd, dengcd);
        return reduce;
    }
    else
    return new Rational(0,1);
    }

    /**
     * TODOUBLE methods overloaded
     * First takes a rational as a parameter and returns it as a double
     * Second takes two integers(numerator and denominator) and returns their quotient
     * Third allows you to return the double value of a Rational object itself
     */

    public static double toDouble(Rational r){
        double staticRationalTemp = 1.0 * r.getNumerator()/r.getDenominator();
        return staticRationalTemp;
    }

    public double toDouble(long numerator, long denominator){
        rationalTemp = 1.0 * numerator/denominator;
        return rationalTemp;
    }

    public double toDouble(){
        rationalTemp = 1.0 * this.numerator/this.denominator;
        return rationalTemp;
    }
    public int compareTo(Rational r){
        if(this.toDouble() > r.toDouble()){
            return 1;
        }
        if(this.toDouble() < r.toDouble()){
            return -1;
        }
        else return 0;
    }

    
    /**
     * TOSTRING methods overloaded
     * First takes a Rational as a parameter and returns it as a String
     * Second takes two integers(numerator and denominator) and returns it as a String
     * Third converts a Rational object itself to a String
     */
    public static String toString(Rational r){
        String s;
        staticDenTemp = r.getDenominator();
        staticNumTemp = r.getNumerator();
        s = Long.toString(staticNumTemp) + "/" + Long.toString(staticDenTemp);
        return s;
    }

    public String toString(long numerator, long denominator){
        stringRational = numerator + "/" + denominator;
        return stringRational;
    }

    public String toString(){
        String s;
        s = this.getNumerator() + "/" + this.getDenominator() ;
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
     * 
     * 
     * Here is the void version of negate but I found the other versions more useful.
     * public void negate(){
     *     this.numerator = -1 + this.numerator;
     * }
     */
    
    public Rational negate(Rational r){
        numTemp = r.getNumerator();
        denTemp = r.getDenominator();
        Rational rTemp = new Rational((-1 * numTemp), denTemp);
        return rTemp;
    }

    public Rational negate(long numerator, long denominator){
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
    public Rational invert(long numerator, long denominator){
        if(numerator == 0){
            System.out.println("This would cause an invalid Rational. Please choose another denominator for your inverse:");
        }
        Rational r = new Rational(denominator, numerator);
        return r;
    }

    public static Rational invert(Rational r){
        if(r.numerator == 0){
            System.out.println("This would cause an invalid Rational. Please choose another denominator for your inverse:");
        }
        Rational rTemp = new Rational(r.getDenominator(), r.getNumerator());
        return rTemp;
    }

    public Rational invert(){
        if(this.numerator == 0){
            System.out.println("This would cause an invalid Rational. Please choose another denominator for your inverse:");
        }
        Rational rTemp = new Rational(this.denominator, this.numerator);
        return rTemp;
    }
    // I didn't like the void version of invert but I included it anyway.
    //public void invert(){                        
        //if(this.getNumerator()!=0){
            //numTemp = this.getNumerator();
            //this.Numerator = this.getDenominator();
            //this.denominator = numTemp;
        //}
        //else
        //System.out.println("This would cause an invalid Rational");
    //}

    /**
     * GREATESTCOMMONDIVISOR method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public static long greatestCommonDivisor(Rational rTemp){
        staticDenTemp = rTemp.getDenominator();
        staticNumTemp = rTemp.getNumerator();
        if (staticDenTemp!=0){
            return greatestCommonDivisor(staticNumTemp, staticDenTemp);
        }
        else
            return staticNumTemp;

    }

    public static long greatestCommonDivisor(long numerator, long denominator){

        if (denominator == 0){
            return numerator;
        }
        else
            return greatestCommonDivisor(denominator, numerator%denominator);
    }


    public long greatestCommonDivisor(){

        if (this.denominator == 0){
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
        long numTemp = r.getNumerator() * p.getNumerator();
        long denTemp = r.getDenominator() * p.getDenominator();
        if(r.getDenominator() != 0 && p.getDenominator() != 0){
        
        Rational rTemp = new Rational(numTemp, denTemp);
        return rTemp.reduce();
        }
       else
       return new Rational(0,1);
    }

    public Rational multiply(long num1, long denom1, long num2, long denom2){
        numTemp = num1 * num2;
        denTemp = denom1 * denom2;
        if(denom1 != 0 && denom2 != 0){
        Rational rTemp = new Rational(numTemp, denTemp);
        return rTemp.reduce();
        }
        else
        return new Rational(0,1);
    }

    public Rational multiply(Rational r){
        if(r.getNumerator() ==0 || this.numerator == 0){
            return new Rational(0,1);
        }
        else
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
            if(p.getNumerator() == 0|| r.getDenominator() == 0){
            return new Rational(0,1);
        }
        else
        staticNumTemp = r.getNumerator() * p.getDenominator();
            staticDenTemp = p.getNumerator() * r.getDenominator();
            long x = staticNumTemp/staticDenTemp;
            Rational rTemp = new Rational(staticNumTemp, staticDenTemp);
            return rTemp.reduce();
        }

    

    public Rational divide(long num1, long denom1, long num2, long denom2){
        try{
            numTemp = num1 * denom2;
            denTemp = denom1 * num2;
            long x = numTemp/denTemp;
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce();
        }
        catch (Exception e){
            Rational rTemp = new Rational(0, 1);
            return rTemp.reduce();

        }
    }

    public Rational divide(Rational r){
        if(this.denominator != 0 && r.getNumerator() != 0){
            numTemp = this.numerator * r.getDenominator();
            denTemp = this.denominator * r.getNumerator();
            long x = numTemp/denTemp;
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp.reduce();
        }
        else
            return new Rational(0, 1);
             

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
            long numTemp = (r.getNumerator() *  p.getDenominator()) + (p.getNumerator() * r.getDenominator());
            long denTemp = (r.getDenominator() * p.getDenominator());
            Rational rTemp = new Rational(numTemp, denTemp);
            return rTemp;  
        }
    }

    public Rational add(long num1, long denom1, long num2, long denom2){
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
            return r;
        }
        else
        numTemp = (r.getNumerator() *  this.getDenominator()) + (this.getNumerator() * r.getDenominator());
        denTemp = (r.getDenominator() * this.getDenominator());
        Rational rTemp = new Rational(numTemp, denTemp);
        return rTemp;    
    }

    /**
     * SUBTRACT method overloaded
     * First takes
     * Second takes
     * Third acts on a Rational object itself
     */
    public static Rational subtract(Rational r, Rational p){
        if(p.getNumerator() == 0){
            return r;
        }
        if(r.getNumerator() == 0){
            return p.negate();
        }
        
        else{
            long numTemp = (r.getNumerator() *  p.getDenominator()) - (p.getNumerator() * r.getDenominator());
            long denTemp = (r.getDenominator() * p.getDenominator());
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
            return rTemp;
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

    
}
 