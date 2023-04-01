//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
	    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
	    
	    for(int i = 0; i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    //make adjacency list of graph vertices and edges
	    for(int i = 0; i<edges.length; i++){
	        adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
	        adj.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
	    }
	    
	    //add initial element to the priorityQueue with weight 0
	    pq.add(new int[]{0,0});
	    boolean[]vis = new boolean[V];
	    
	    //take care of total sum of minimum spanning tree 
	    int sum = 0;
	    
	    //E log E
	    while(!pq.isEmpty()){
	        int[]node = pq.remove();
	        int wt = node[1];
	        int u = node[0];
	        
	        if(vis[u] == true){
	            continue;
	        }
	        
	        vis[u] = true;
	        sum+= wt;
	        
	        for(int i = 0; i<adj.get(u).size(); i++){
	            int v = adj.get(u).get(i)[0];
	            int newWt = adj.get(u).get(i)[1];
	            if(!vis[v]){
	                pq.add(new int[]{v,newWt});
	            }
	        }
	    }
	    return sum;
	}
}