class Solution {
    
    static class pair{
        String s;
        int steps;
        
        public pair(String s,int steps){
            this.s = s;
            this.steps = steps;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair>q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        
        q.add(new pair(beginWord,1));
        set.remove(beginWord);
        
        while(!q.isEmpty()){
            String word = q.peek().s;
            int steps = q.peek().steps;
            q.remove();
            
            if(word.equals(endWord))return steps;
            
            for(int i = 0; i<word.length();i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] toreplace = word.toCharArray();
                    toreplace[i] = ch;
                    String newWord = new String(toreplace);
                    
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new pair(newWord,steps+1));
                    }
                }
               
            }
        }
        return 0;
    }
}