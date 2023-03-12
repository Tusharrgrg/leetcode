class Solution {
    public int maxScore(int[] nums) {
        
        Arrays.sort(nums);
        int sum = 0;
        int count = 0;
        int n = nums.length;
        long[]num =new long[n];
        
        num[n-1] = (long)nums[n-1];
        
        if(nums[n-1]>0){
            count++;
        }
        for(int i = n-2;i>=0;i--){
           num[i] = (long)nums[i]+num[i+1];
            if(num[i]>0){
                count++;
            }
        }
        return count;
    }
}


// [-687767,-860350,950296,52109,510127,545329,-291223,-966728,852403,828596,456730,-483632,-529386,356766,147293,572374,
//  243605,931468,641668,494446]