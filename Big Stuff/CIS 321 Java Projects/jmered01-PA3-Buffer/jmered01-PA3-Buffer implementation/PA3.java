/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author shasso
 */
public class PA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CareTaker ct = new CareTaker();
        DocumentBuffer buffer = new DocumentBuffer(ct);

        System.out.println("inserting new line...");
        buffer.addLine(new Line("line 1", 1));
        System.out.println(buffer);
        System.out.println("***************");

        // add line
        System.out.println("inserting new line...");
        buffer.addLine(new Line("line 2", 2));
        System.out.println(buffer);
        System.out.println("***************");

        // add line
        System.out.println("inserting new line...");
        buffer.addLine(new Line("line 3", 3));

        System.out.println(buffer);
        System.out.println("***************");

        // add line
        System.out.println("inserting new line...");
        buffer.addLine(new Line("line 4", 4));

        System.out.println(buffer);
        System.out.println("***************");

        // remove line 2
        System.out.println("removing  a line...");
        buffer.removeLine(2);
        System.out.println(buffer);
        System.out.println("***************");

        // undo last insert
        System.out.println("undo last operation...");
        boolean rc = buffer.undo();
        System.out.println(buffer);
        System.out.println("***************");

        // undo last insert
        System.out.println("undo last operation...");
        rc = buffer.undo();
        System.out.println(buffer);
        System.out.println("***************");

    }

}