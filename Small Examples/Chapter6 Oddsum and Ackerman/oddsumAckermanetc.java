import java.util.Scanner;
/**
 * Write a description of class oddsumAckermanetc here.
 *
 * @author Johnnie Meredith 
 * @version 1.1
 */

public class oddsumAckermanetc
{
    public int ackerman(int m, int n){
        if (m == 0){
        return n+1;
    }
    else if (m>0&&n == 0){
        return ackerman(m-1,1);
    }
    else if (m>0&&n>0){
        return ackerman(m-1,ackerman(m,n-1));
    
    }
    return 0;
   } 
   public int oddsum(int n){
    int total = 0;         
    for (int x = 1; x < n; x++)
    {
            if ((x%2)!=0)
            {
                total += x;
            }        
    }
        return total;
    
   }
    public double powera(double base, int power){    
    if(power == 0) {
        return 1;
    }
    double powera = base * powera(base, --power);
    return powera;
   }   
    public void main() {
        int x;
        int y;
        System.out.println("press 1 for ackerman 2 for power or 3 for oddsum");
        Scanner menu = new Scanner(System.in);
        int choice = menu.nextInt();
        if(choice==1){
            System.out.println("Now running Ackerman. Select first integer:");
            Scanner intA = new Scanner(System.in);
            x = intA.nextInt();
            System.out.println("Select second integer:");
            Scanner intB = new Scanner(System.in);
            y = intB.nextInt();
            System.out.println(ackerman(x,y));
        }
        else if (choice==2){
        System.out.println("Now running Power. Select a number:");
        Scanner numA = new Scanner(System.in);
        x = numA.nextInt();
        System.out.println("Select a number to use as a power to raise it:");
        Scanner numB = new Scanner(System.in);
        y = numB.nextInt();
        System.out.println(powera(x,y));
       }
        else if (choice==3){
        System.out.println("calling oddsum");
        System.out.print("Enter a number:");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        System.out.println(oddsum(n));
       }
  }
}

