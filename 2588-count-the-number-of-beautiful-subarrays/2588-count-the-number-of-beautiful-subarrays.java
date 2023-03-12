class Solution {
    public long beautifulSubarrays(int[] nums) {
       
        
        int xor = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i<nums.length; i++){
            xor = xor^nums[i];
            if(map.containsKey(xor)){
                map.put(xor, map.get(xor)+1);
            }else{
                map.put(xor,1);
            }
        }
        
        long value = 0;
         for(long beautiful:map.values()){
            value+=(beautiful*(beautiful-1))/2;
        }
        
        // System.out.println(Arrays.toString(xor));
        return value;
    }
}