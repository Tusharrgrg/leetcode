class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         
        int N = intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        
        int count = 0;
        int prevEnd = intervals[0][1]; 
        
        for(int i = 1; i<N; i++){
            if(intervals[i][0] <prevEnd){
                count+=1;
            }else{
                prevEnd = intervals[i][1]; 
            }
        }
        return count;
    }
}