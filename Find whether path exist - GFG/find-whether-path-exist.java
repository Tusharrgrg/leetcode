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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int[]src = new int[2];
        int[]des = new int[2];
        
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j] == 2){
                    des[0]= i;
                    des[1] =j;
                }
                if(grid[i][j] == 1){
                    src[0] = i;
                    src[1] = j;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][]vis = new boolean[n][n];
        int ir = src[0];
        int ic = src[1];
        q.add(new int[]{ir,ic});
        
        int[][]dis = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!q.isEmpty()){
            int[]node = q.remove();
            int row = node[0];
            int col = node[1];
            vis[row][col] = true;
            if(row == des[0]&&col == des[1]){
                return true;
            }

            for(int i = 0; i<4;i++){
                int nr = row+dis[i][0];
                int nc = col+dis[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc<n&&!vis[nr][nc] && grid[nr][nc] != 0) {
                    q.add(new int[]{nr,nc});
                }
            }
        }
        // System.out.println(Arrays.toString(src));
        return false;
    }
}