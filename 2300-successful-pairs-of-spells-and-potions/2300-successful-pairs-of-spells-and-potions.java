class Solution {
    public int[] successfulPairs(int[] spells, int[] positions, long success) {
        Arrays.sort(positions);
        int[] result = new int[spells.length];
        int n = positions.length;
        
        for(int i = 0; i<spells.length; i++){
            int start = 0;
            int end = positions.length;
            // int pair = 0;
            while(start<end){             
                int mid = start+(end-start)/2;
                long ans = 1L*positions[mid]*spells[i];
                if(ans>= success){
                    end = mid;
                }else{
                    start = mid+1;
                }
            }
            result[i] = n-start;
        }
        
        return result;
        
    }
}