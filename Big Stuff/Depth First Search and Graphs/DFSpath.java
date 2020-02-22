import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class  DFSpath {
    static StringBuilder s;
	static ArrayList<Integer>[] adj;
    static boolean[] visited; 
    static int connected;
	public static void main(String[] args ) throws FileNotFoundException{
        connected = 0;
		String fileName = args[0];
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		int n = Integer.parseInt(scanner.nextLine());
        adj = new ArrayList[n];
        s = new StringBuilder();
		for (int i=0; i<n; i++){
			adj[i] = new ArrayList<>();
		} 
		while (scanner.hasNextLine()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        scanner.close();
        visited= new boolean[n];
        int source = Integer.parseInt(args[1]);
        int destin = Integer.parseInt(args[2]);
        dfs(source,destin);
        if(visited[destin]==true){
            System.out.println(s.reverse());
        }
        
	}
	private static void dfs(int w, int destination){
        visited[w] = true;
		for (int i=0; i<adj[w].size(); i++){
			int u = adj[w].get(i);
            if(!visited[destination] && !visited[u]) {
                dfs(u, destination);
            }
        }
        if(visited[destination]){
            s.append(" " + w );
        }
	}
} 