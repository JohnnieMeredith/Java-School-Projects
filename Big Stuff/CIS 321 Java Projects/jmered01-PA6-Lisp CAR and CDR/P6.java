/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package p6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author shasso
 */
public class P6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Character[] m = { 'A', 'B', 'C', 'D', 'E' };
        List<Character> letters = new ArrayList<>(Arrays.asList(m));
        ILispMethodsList<Character> lp = new LispMethodsList<Character>();
        // test my car and cdr methods
        System.out.println(lp.car(letters));

        List<Character> rm = lp.cdr(letters);
        for (Character c : rm) {
            System.out.print(c + " ");
        }
        System.out.println();

        // test recursive methods
        int n = length_rec(lp, letters);
        System.out.println(n);
        //System.out.println(letters);//debug print the members of letters
        Character x = 'C';
        System.out.println(member(lp, letters, x)); 
        System.out.println(); 
    }

    /**
     * count length of string passed using lisp service provider methods
     * @param lp  lisp method service provider
     * @param container actual list you are checking
     * @return lenth of list
     */
    private static int length_rec(ILispMethodsList<Character> lp, List<Character> container) {
        //you complete this code
        
        if(lp.cdr(container)==(null)){
            return 0;
        }
        else
            return length_rec(lp,lp.cdr(container))+1;
    }

    /**
     * check if a character is a member in the list
     * 
     * @param lp        lisp method service provider
     * @param container actual list you are checking
     * @param c         character you are trying to find
     * @return
     */
    private static boolean member(ILispMethodsList<Character> lp, List<Character> container, Character c) {
        // you complete this code

        if(length_rec(lp, container) == 0){
            return false;
        }
        else if(lp.car(container) == c)
            return true;
        else {
            return(member(lp,lp.cdr(container),c));
        }
    }
}
