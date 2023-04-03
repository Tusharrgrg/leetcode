class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans  = new ArrayList<>(); 
        List<Integer> unique = new ArrayList<>();
    
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(!unique.contains(nums[i])){
                unique.add(nums[i]);
            }
        }
        while(map.size()!=0){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i<unique.size();i++){
                int num = unique.get(i);
                
                if(map.containsKey(num)){
                    if(map.get(num)<1){
                        map.remove(num);
                    }else{
                        temp.add(num);
                        map.put(num,map.get(num)-1);
                    }
                }
            }
            if(temp.size()>0){
                ans.add(temp);
            }
        }
    return ans;
    }
}