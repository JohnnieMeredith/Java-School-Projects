import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class DFSpost {
	static ArrayList<Integer>[] adj;
    static boolean[] visited; 
    
	public static void main(String[] args) throws FileNotFoundException{
		String fileName = args[0];
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
        int n = Integer.parseInt(scanner.nextLine());
        adj = new ArrayList[n];
		for (int i=0; i<n; i++){
			adj[i] = new ArrayList<>();
		} 
		while (scanner.hasNextLine()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adj[x].add(y);
			//adj[y].add(x);
			//System.out.println(adj[x]);
        }
        scanner.close();
        visited= new boolean[n]; 
        
        System.out.println();
	}
	private static void dfs(int w){
		visited[w] = true;
		for (int i=0; i < adj[w].size(); i++){
			int u = adj[w].get(i);
            if (!visited[u]) dfs(u);
            
        }
        System.out.print(w + " ");
	}
} 