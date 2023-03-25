class Solution {
    public long countPairs(int n, int[][] edges) {
        
        List<List<Integer>>adj = new ArrayList<>();
        for(int i= 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[]vis = new boolean[n];
        List<Integer> it = new ArrayList<>();
        int count = 0;
        long ans = 0;
        for(int i = 0; i<n ;i++){
            if(!vis[i]){
                int cnt = dfs(adj,i,vis);
                ans += (long)cnt*count;
                count +=cnt;
            }
        }
        
        // if(count == 1){
        //     return 0l;
        // }
        
//         int num = it.get(0);
//         int num1 = it.get(0);
//         long ans = (long)num;
        
//         for(int j = 1; j<count ; j++){
//             int s = it.get(num);
//             ans = ans+s;
//             num = num+s;
//         }
        
//         System.out.println(count);
        return ans;
    }
    
    public static int dfs(List<List<Integer>>adj,int start, boolean[]vis){
        vis[start] = true;
        int cnt = 1;
        for(int u : adj.get(start)){
            if(vis[u]==false){
                cnt += dfs(adj,u,vis);
            }
            
        }
        return cnt;
    }
}