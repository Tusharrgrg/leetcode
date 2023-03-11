class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        List<int[]>result = new ArrayList<>();
        
        int[] curr = intervals[0];
        result.add(curr);
        // curr[1] = 0;
        // System.out.println(Arrays.toString(result.get(0)));
        
        for(int[] interval:intervals){
          
            if(interval[0]<=curr[1]){
                curr[1] = Math.max(curr[1], interval[1]);
            }else{
                curr = interval;
                result.add(curr);
            }
        }
        
        //When you add an array to a list in Java,\
        // you are actually adding a reference to the array. 
        //This means that if you later modify the contents of the array, 
        //those modifications will be reflected in the list.
        
        return result.toArray(new int[result.size()][]);
    }
}