/**
 * @author Johnnie Meredith
 * @version March 18, 2018
 * 
 */
public class Student implements StudentI
{
    int tc ;
    String[] classes; 
    public Student() {
        // Declare and initialize an empty array of Strings to hold the class names.
        this.tc = 0;
        this.classes = new String[100];

    }

    public void addClass(String s) {
        // Add the given string to the array. Also keep track of how many were added.
        tc++;
        classes[tc] = s;

    }

    public boolean checkOverlap(StudentI other) {
        // Answer whether this instance has a class in common with other. Use hasClass().
        for(int x = 1; x <= tc; x++){

            if  (other.hasClass(classes[x])){
                return true;
            }

        }
        return false;
    }

    public boolean hasClass(String s) {
        // Answer whether this instance has the given string in its array.

        for(int y = 1; y <= tc; y++){
            if (classes[y].equals(s)){
                return true;
            }

        }
        return false;
    }
}
