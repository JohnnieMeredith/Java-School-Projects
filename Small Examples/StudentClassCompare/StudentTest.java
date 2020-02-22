public class StudentTest
{
    public static void main () {
   
        StudentI student1 = new Student ();
        student1.addClass("CIS211");
        student1.addClass("ECON104");
        student1.addClass("MATH105");
        student1.addClass("HIST254");
        
        StudentI student2 = new Student ();
        student2.addClass("THEA201");
        student2.addClass("CIS211");
        student2.addClass("BIOL206");

        StudentI student3 = new Student ();
        student3.addClass("CIS104");
        student3.addClass("CIS211");

        System.out.println("Expect true: 1 intersects 2? "+
        student1.checkOverlap(student2));
        System.out.println("Expect false: 2 intersects 3? "+
        student2.checkOverlap(student3));
    }
        
}