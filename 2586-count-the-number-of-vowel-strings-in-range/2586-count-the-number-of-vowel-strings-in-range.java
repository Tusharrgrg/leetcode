class Solution {
    public int vowelStrings(String[] words, int left, int right) {
            String t = "aeiou";
            int count = 0;
        for(int i = left ; i<=right; i++){
            String s = words[i];
            int n = s.length();
            
            if(t.contains(String.valueOf(s.charAt(0))) && t.contains(String.valueOf(s.charAt(n-1)))){
                count++;
            }
        }
        return count;
    }
}