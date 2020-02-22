import java.io.*;
import java.lang.ProcessBuilder;
import java.net.*;
       
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class OSProcess {
    



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        if (args.length > 3)
        {
            System.err.println("Usage: java OSProcess <command>");
            System.exit(0);
        }
        
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "/start");
        Process proc = pb.start();
        
        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close ();
                
    
    
}
}
