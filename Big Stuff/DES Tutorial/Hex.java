public class Hex{  
public static int getDecimal(String hex){
    String digits = "0123456789ABCDEF";
             hex = hex.toUpperCase();
             int val = 0;
             for (int i = 0; i < hex.length(); i++)
             {
                 char c = hex.charAt(i);
                 int d = digits.indexOf(c);
                 val = 16*val + d;
             }
             return val;
}
public static void main(String args[]){  
System.out.println("Decimal of 3A1F009E5DF47820 is: "+ " " +getDecimal("3A")+ " " 
+getDecimal("1F") + " " + getDecimal("00") + " " + getDecimal("9E") + " " + getDecimal("5D") + " "
+ getDecimal("F4") + " " +getDecimal("78") + " " +getDecimal("20"));
System.out.println(getDecimal("3A1F009E5DF47820"));
System.out.println("Decimal of 121 is: "+getDecimal("121"));
}}  
