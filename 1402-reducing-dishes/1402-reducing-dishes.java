class Solution {
    static int [][]dp = new int[501][501];
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        for(int i []:dp){
            Arrays.fill(i,-1);
        }
        
        return solve(satisfaction, 0, 1);
        
    }
    
    public static int solve(int[] satisfaction,int i,int time){
        if(i == satisfaction.length){
            return 0;
        }
        
        if(dp[i][time]!=-1){
            return dp[i][time];
        }
        int include = satisfaction[i]*time + solve(satisfaction, i+1, time+1);
        int exclude = solve(satisfaction, i+1, time);
        return dp[i][time] =  Math.max(include,exclude);
    }
}

//315 239