class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int n = days.length;
        
       int[] dp = new int[n+1];
       Arrays.fill(dp,Integer.MAX_VALUE);
       dp[n] = 0;
       for(int idx = n-1; idx>=0 ; idx--){
        int opt1 = cost[0] + dp[idx+1];
        
        int i ;
        for(i = idx;i<n && days[i]<days[idx]+7;i++);
        int opt2 = cost[1] + dp[i];

        int j;
        for(j = idx;j<n && days[j]<days[idx]+30;j++);
        int opt3 = cost[2] + dp[j];

        dp[idx] = Math.min(opt1,Math.min(opt2,opt3));
       }
       return dp[0];
    }
}