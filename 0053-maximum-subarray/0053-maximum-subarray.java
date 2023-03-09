class Solution {
    public int maxSubArray(int[] nums) {
        int total = Integer.MIN_VALUE;
        int curr = 0;
        
        // using kadane's algo 
        
        for(int i = 0; i<nums.length; i++){
            curr = curr+nums[i];
            total = Math.max(curr,total);
            
            if(curr <0){
                curr = 0;
            }
        }
        
        return total;
    }
}