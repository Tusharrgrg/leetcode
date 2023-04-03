//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        Queue<int[]> pq = new LinkedList<>();
        if(A[0][0] == 0){
            return -1;
        }
        
        int[][]dis = new int[N][M];
        
        for(int[]i:dis){
            Arrays.fill(i,(int)1e8);
        }
        
        dis[0][0] = 0;
        A[0][0] = 0;
        
        int[][]dir = {{-1,0},{0,-1},{0,1},{1,0}};
        
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            
            int[]node = pq.remove();
            int d = node[0];
            int row = node[1];
            int col = node[2];
            
            if(row == X && col == Y){
                return d;
            }
            
            for(int i = 0; i<4; i++){
                int nr = row+dir[i][0];
                int nc = col+dir[i][1];
                
                if(nr<N && nc<M && nr>=0 && nc>=0 && A[nr][nc]!=0){
                    if(d+1 < dis[nr][nc]){
                        dis[nr][nc] = d+1;
                        pq.add(new int[]{d+1, nr,nc});
                        A[nr][nc] = 0;
                    }
                }
            }
        }
        
        return -1;
    }
};