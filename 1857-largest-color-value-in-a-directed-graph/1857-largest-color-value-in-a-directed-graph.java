class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[]indegree = new int[n];
        int[][]dp = new int[n][26];
        
        
        for(int i = 0; i<colors.length();i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<edges.length ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
             indegree[edges[i][1]]++;
        }
        
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
                dp[i][colors.charAt(i)-'a'] = 1;
            }
        }
        
        int count = 0;
        int ans  = 0;
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
           
            count++;
            ans = Math.max(dp[node][colors.charAt(node)-'a'],ans);
            
            for(int u:adj.get(node)){
                
                for(int i = 0; i<26; i++){
                    int temp = 0;
                    if(colors.charAt(u)-'a' == i){
                         temp = 1;
                    }
                    dp[u][i] = Math.max(dp[u][i], dp[node][i]+temp);
                }
                indegree[u]--;
                if(indegree[u] == 0){
                    q.add(u);
                }
            }
        }
        
       if(count<n){
           return -1;
       }
        
        return ans;
    }
    
    
}