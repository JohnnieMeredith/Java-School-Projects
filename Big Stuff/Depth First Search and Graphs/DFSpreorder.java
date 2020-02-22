import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class DFSpreorder {
	static ArrayList<Integer>[] adj;
    static boolean[] visited; 
    static int visitedSize;
	public static void main(String[] args) throws FileNotFoundException{
		String fileName = args[0];
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
        int n = Integer.parseInt(scanner.nextLine());
        visitedSize = n;
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
		for (int x = 0; x < n; x++){
			
			if (!visited[x]) dfs(x);
		} 
        System.out.println();
	}
	private static void dfs(int w){
		visited[w] = true;
		System.out.print(w + " ");
		for (int i=0; i<adj[w].size(); i++){
			int u = adj[w].get(i);
			if (!visited[u]) dfs(u);
        }
       
		
	}
} 