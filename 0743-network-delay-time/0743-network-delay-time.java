class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        List<List<int[]>> adj = new ArrayList<>();
        
        
        for(int i = 0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adj.get(u).add(new int[]{v,time});
        }
        
        
        
        int dis[] = new int[n+1];
        
        Arrays.fill(dis,Integer.MAX_VALUE);
        
        dis[k] = 0;
        pq.add(new int[]{0,k});
        
        while(!pq.isEmpty()){
            int[] node = pq.remove();
            
            int d = node[0];
            int s = node[1];
            
            for(int[] b : adj.get(s)){
                if(b[1]+d < dis[b[0]]){
                    dis[b[0]] = b[1]+d;
                    pq.add(new int[]{dis[b[0]], b[0]});
                }
            }
        }
        
        int maxDis = 0;
        for(int i = 1; i<=n; i++){
             maxDis = Math.max(maxDis, dis[i]);
        }
        
        if(maxDis == Integer.MAX_VALUE){
            return -1;
        }
       
        return maxDis;
        
    }
}