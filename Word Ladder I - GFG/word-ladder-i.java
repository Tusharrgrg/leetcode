//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    static class pair{
        String first;
        int second;
        public pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public int wordLadderLength(String start, String target, String[] wordList)
    {
        // Code here
         //define a queue to use bfs algorithm for this problem
        Queue<pair>q = new LinkedList<>();

        //initialize a set table for keep traking words
        Set<String> set = new HashSet<>();

        for(int i = 0; i<wordList.length; i++){
            set.add(wordList[i]);
        }

        q.add(new pair(start, 1));
        set.remove(start);

        while(!q.isEmpty()){
            int steps = q.peek().second;
            String word = q.peek().first;

            q.remove();
            if(word.equals(target)) return steps;
            
            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] toreplace = word.toCharArray();
                    toreplace[i] = ch;
                    String newWord = new String(toreplace);

                    if(set.contains(newWord)){
                        q.add(new pair(newWord, steps+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}