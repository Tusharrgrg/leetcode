class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int start = 1;
        int end = max(piles);
        int ans = -1;
        while(start<= end){
            int mid = start+(end-start)/2;
            if(minHour(piles, h, mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        
        return ans;
        
    }
    
    boolean minHour(int[] piles, int h, int k){
        long hour = 0;
        for(int i =0; i<piles.length; i++){
            
            int div = piles[i]/k;
            hour+= (long)div;
            if(piles[i]%k != 0) {
                hour++;
            }
        }
        return hour<= h;
    }
    
    
    int max(int[] arr){
        int m = arr[0];
        for(int i =0; i<arr.length; i++){
            if(arr[i]>m){
                m = arr[i];
            }
        }
        return m;
    }
}