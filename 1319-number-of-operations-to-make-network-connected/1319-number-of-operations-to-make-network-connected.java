class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<connections.length; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        
        boolean[]vis = new boolean[n];
        int count = 0;
        for(int i = 0; i<n ;i++){
            if(!vis[i]){
                dfs(adj,i,vis);
                count++;
            }
        }
        System.out.println(count);
        if(count == 1){
            return 0;
        }
        if(connections.length >= n-1){
            return count-1;
        }
        
        return -1;
    }
    
    public static void dfs(List<List<Integer>> adj , int u, boolean[]vis){
        vis[u] = true;
        
        for(int i : adj.get(u)){
            if(!vis[i]){
                dfs(adj,i,vis);
            }
        }
    }
}