/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package p7;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 *
 * @author shasso
 */
public class P7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String fileName = args[0]; // data file name
        if (args.length == 0) {
            usage("you need to specify morse code tree file.");
        }
        MorseCodeTree mct = new MorseCodeTree(fileName);
        String[] codes = {
                "-, ...., .",
                "-..., .-, .-., .-., .., ., .-., ...",
                ".-, .-., .",
                "-., ---, -",
                "., .-., ., -.-., -, ., -..",
                ".--, ...., .., -.-., ....",
                "-.-., .-, -.",
                "..., .-, -.--",
                "-, ---",
                ".-, ..., .--., .., .-., .., -., --.",
                "-, .-, .-.., ., -., -, ...",
                ".-, -., -..",
                ".., -., -.., ..-, ..., -, .-., -.--",
                "-, ...., ..-, ...",
                "..-., .-, .-.",
                ".-, -., -..",
                "-., ---",
                "..-., .-, .-., -, ...., ., .-."
            };
        for (String s : codes) {
            String[] w = s.split(","); // split on ","
            String decoded = "";
            for (String x : w) {
                char c = decode(x.trim(), mct);
                decoded += c;
            }
            System.out.println(s + " --> " + decoded);
        }
        System.out.println();
    }

    /**
     * 
     * @param codedMsg Morse encoded word, e.g. "...." 
     * @param mct Morse code tree 
     * @return decode character, e.g. 'h'
     */
    public static char decode(String codedMsg, MorseCodeTree mct) {
        // you complete the code
        int level = 0;
        BinaryTree temp = mct.getMct();
        while(level < codedMsg.length()){
            //return mct.getMct().getData().getSymbol();
            if(codedMsg.charAt(level) == '.' && mct.getMct().getLeftSubtree() != null){
                level++;
                temp = mct.getMct().getLeftSubtree();
                return  decode(codedMsg.substring(level), new MorseCodeTree(temp));
            }
            else if(codedMsg.charAt(level) == '-' && mct.getMct().getRightSubtree() != null){
                level++;
                temp = mct.getMct().getRightSubtree();
                return decode(codedMsg.substring(level), new MorseCodeTree(temp));
            }

        }
        return mct.getMct().getData().getSymbol();
    }

    private static void usage(String msg) {
        System.err.println(msg);
        System.exit(-1);
    }

}