class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        // long[] ans = new long[n];
        // Arrays.fill(ans,0);
        
        //Brute force approach TC - O(N)
        
        // for(int i = 0; i<n ;i++){
        //     for(int j = 0; j<n;j++){
        //         if(nums[i] == nums[j] && i!=j){
        //             ans[i]+= Math.abs(i-j);
        //         }
        //     }
        // }
        
        
         Map<Long,long[]> map = new HashMap<>(); 
        // [0] -> sum of indices at left of i
        // [1] -> sum of indices at right of i
        // [2] -> left freq
        // [3] -> right freq
        int i=0;
        for(int e:nums)
        {
            long x = e;
            if(map.get(x)==null){
                map.put(x,new long[4]);
            }
            map.get(x)[1]+=i++; // total sum of indices with value x
            map.get(x)[3]++;    // no. of occurences of x in arr
        }
        
        long[] res = new long[n];
        i=0;
        for(int e:nums)
        {
            long x = e;
            long[] temp = map.get(x);
            temp[1]-=i;  // sum of indices at right
            temp[3]--;   // right freq
            res[i]=Math.abs(temp[0]-i*temp[2])+Math.abs(temp[1]-i*temp[3]);
            temp[0]+=i++;  // sum of indices at left
            temp[2]++;   // left freq
        }
        return res;
    }
}