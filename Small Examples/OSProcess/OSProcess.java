import java.io.*;
import java.lang.ProcessBuilder;
       
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melanie
 */
public class OSProcess {
    



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1)
        {
            System.err.println("Usage: java OSProcess <command>");
            System.exit(0);
        }
        
        ProcessBuilder pb = new ProcessBuilder(args[0]);
        Process proc = pb.start();
        
        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader (is);
        BufferedReader br = new BufferedReader(isr);
        
        String line;
        while((line = br.readLine()) != null)
            System.out.println(line);
        
        br.close();
                
    
    
}
