//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] path =new boolean[v];
        boolean[] vis = new boolean[v];

        for(int i = 0; i<v; i++){
            if(!vis[i]){
                if(directedDFS(adj, path, vis, i) == true)return true;
            }
        }
        return false;
    }
    
     public static boolean directedDFS(ArrayList<ArrayList<Integer>> adj, boolean[] path, boolean[] vis, int v){
        path[v] = true;
        vis[v] = true;

        for(int i:adj.get(v)){
            if(!vis[i]){
                if(directedDFS(adj, path, vis, i)==true){
                    return true;
                }
            }else if(path[i]){
                return true;
            }
        }
        path[v] = false;
        return false;
    }
}