import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
class DFSmaze {
	static ArrayList<Integer>[] adj;
    public static boolean[][] hWall; 
    public static boolean[][] vWall;
    static final int SQUARESIZE = 20;
    static boolean visited[];
    
    public static void fillMaze(int mazeSize){
        hWall = new boolean[21][21];
        vWall = new boolean[21][21];
        for(int x = 0; x <21; x++ ){
            for(int y = 0; y <21;y++){
                hWall[x][y] = true;
                vWall[x][y] = true;
            }
        }
    }
    
    
	public static void main(String[] args) {
        
        fillMaze(20);
        
        
        adj = new ArrayList[400];
        for (int i=0; i < 400; i++){
			adj[i] = new ArrayList<>();
		} 
        for(int x = 0; x < 400; x++){
            if(x == 0){
                adj[x].add(x+1);
                adj[x].add(x+20);
            }
            else if(x < 20){
                adj[x].add(x-1);
                adj[x].add(x+1);
                adj[x].add(x+20);
            }
            else if(x == 399){
                adj[x].add(x-1);
                adj[x].add(x-20);
            }
            else if(x >= 380){
                adj[x].add(x-1);
                adj[x].add(x+1);
                adj[x].add(x-20);
            }
            else if(x % 20 == 0){
                adj[x].add(x+1);
                adj[x].add(x-20);
                adj[x].add(x+20);
            }
            
            else if((x % 20) == 19){
                adj[x].add(x-1);
                adj[x].add(x-20);
                adj[x].add(x+20);
            }
            else{
            adj[x].add(x-1);
            adj[x].add(x+1);
            adj[x].add(x+20);
            adj[x].add(x-20);
            }
		}
        visited = new boolean[400]; 
        /* for (int x = 0; x < 399; x++){

			if (!visited[x]) { */
                dfs(0);
            //}
        
        MazeFrame f = new MazeFrame();
        f.setTitle("Random DFS Maze");
        f.setBounds(100,50,500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        
	}
	private static void dfs(int w){
        visited[w] = true;
        Random rnd = new Random();
        
        while(adj[w].size() >= 1){
        int dir = rnd.nextInt(adj[w].size());
        int u = adj[w].get(dir);
        adj[w].remove(dir);
        if (!visited[u]){
            if((w - u) == 1)vWall[w/20][w%20] = false; //issue
            if((w - u) == -1)vWall[w/20][(u)%20] = false;
            if((w - u) == 20)hWall[(u/20)][w%20] = false; //possible issue
            if((w - u) == -20)hWall[w/20+1][w%20] = false;
                
            dfs(u);
            
        }
        
    }
        System.out.print(w + " ");
    }
    
    

    static class MazeFrame extends JFrame {
        public void paint(Graphics g) {
            //g.drawLine(40,40,40,440);
           // g.drawLine(440,40,440,40);
           // g.drawLine(40,40,440,40);
            //g.drawLine(440, 40, 440, 440);
            //g.drawLine(40, 440, 440, 440);
            for (int i=0; i<21; i++){
           //g.drawLine(40+i*20,40,40+i*20,440); // vertical walls
                for (int x=0; x<21; x++){
                    if(vWall[i][x] == true) {
                        g.drawLine((x*20),(i*20),(x*20),((i+1)*20)); // vertical walls
                    }
                }
            }
                for(int y = 0; y < 21; y++){
                    for(int z = 0; z < 21 ; z++){
                
                        if(hWall[y][z] == true){
                            //g.drawLine(40+(z*20),40+(y*20),40+(z+1)*20,40+(y*20));
                        }
                    }
                    
            
                    
                    //g.drawLine(40,40+i*20,440,40+i*20); // horizontal walls
            }
                System.out.println("done");
        }
    }
}

