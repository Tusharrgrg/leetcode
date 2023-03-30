class Solution {
    
    HashMap<String,Boolean> map = new HashMap<>();
    
    public boolean isScramble(String a, String b) {
        
        if(a.length() != b.length()) return false;   
        if(a.isEmpty() == true) return true;
        
        return helper(a, b);
    }
    
     public boolean helper(String a, String b)
    {
        if(a.equals(b) == true) return true;  
        
        if(a.length() <= 1) return false;  
        
         String key = a+"-"+b;
         
         if(map.containsKey(key)){
             return map.get(key);
         }
         
        int n = a.length();
        boolean flag = false;
        
        for(int i = 1; i < n; i++)
        {
            boolean swap = helper(a.substring(0, i), b.substring(n - i)) && helper(a.substring(i), b.substring(0, n - i));
            boolean unswap = helper(a.substring(0,i), b.substring(0,i)) && helper(a.substring(i), b.substring(i));
            
            if(swap || unswap){
                flag = true;
                break;
            }
        }
         
         map.put(key,flag);
        
        return flag;
    }
}