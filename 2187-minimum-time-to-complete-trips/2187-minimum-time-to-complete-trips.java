class Solution {
    public long minimumTime(int[] time, int totalTrips) {
//         long sum = 0;
//         long t = 1;
        
//         while(true){
//             for(int i = 0; i<time.length; i++){
//                 sum+= t/time[i];
//             }
//             if(sum>=totalTrips){
//                 return t;
//             }else{
//                 t++;
//                 sum = 0;
//             }
//         }
        // return 0;
        long min = Long.MAX_VALUE;
        
        for(int i = 0; i<time.length; i++){
            min =(long) Math.min(min,time[i]);
        }
        
        long li = 1;
        long hi = min*(long)totalTrips;
        
        while(li<hi){
            long mid = li+(hi-li)/2;
            
            if(calculate(time,mid,totalTrips)){
                hi = mid;
            }else{
                li = mid+1;
            }            
        }
        
        return li;
    }
    
    public static boolean calculate(int[]arr, long time,int trip){
        long sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum+= time/arr[i];
        }
        
        return sum>=trip;
    }
}