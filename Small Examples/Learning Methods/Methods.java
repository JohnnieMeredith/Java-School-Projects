
/**
 * Cis 104 Think Java Exercise Chapter 4
 * Void Methods
 *
 * @Johnnie Meredith    
 * @version 0.1 November 25 2017
 */
public class Methods
{
    int date = 25;
    int year = 2017;
    String month = "November";
    String day = "Saturday";
    int a = 11;
    String petName = "MewMew";
    String streetName = "Cloverdale Rd.";
    public void newLine()
    {
        System.out.println();
    }
    
    public void zool(int x, String petName, String streetName)
    {
        
        System.out.println(x);
        System.out.println(petName);
        System.out.println(streetName);
        
    }
    public void printAmerican(int date, int year, String month, String day)
    {
        System.out.println(day + "," + month +" " + date + " " + year);
    }
    public void printEuropean(int date, int year, String month, String day)
    {
        System.out.println(day + " " + date + " " + month + ", " + year);
    }
    public void main()
    {
        System.out.println("Now main is calling zool().");
        newLine();
        zool(a, petName, streetName);
        newLine();
        newLine();
        System.out.println("Now main is calling printAmerican().");
        newLine();
        printAmerican(date, year, month, day);
        newLine();
        newLine();
        System.out.println("Now main is calling printEuropean().");
        newLine();
        printEuropean(date, year, month, day);
    }   
}
