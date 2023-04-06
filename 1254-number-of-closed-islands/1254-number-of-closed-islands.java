class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][]vis = new boolean[n][m];
        int count = 0;
        
        
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 0 && vis[0][i] == false) {
                dfs(grid, 0, i,vis);
            }

            if (grid[n - 1][i] == 0 && vis[n - 1][i] == false) {
                dfs(grid, n - 1, i,vis);
            }
        }

        // for first and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0 && vis[i][0] == false) {
                dfs(grid, i, 0,vis);
            }
            if (grid[i][m - 1] == 0 && vis[i][m - 1] == false) {
                dfs(grid, i, m - 1, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j] ==false && grid[i][j] == 0){
                    dfs(grid, i,j,vis);
                    count++;
                }
            }
        }
        
        
       
        return count;
    }
    
    public static void dfs(int[][]grid, int row,int col, boolean[][]vis){
        if(row>=grid.length || col >= grid[0].length || col<0 || row<0 || 
           grid[row][col] ==1 || vis[row][col] ==true ){
            return ;
        }
        vis[row][col] = true;
        dfs(grid,row+1,col,vis);
        dfs(grid,row-1,col,vis);
        dfs(grid,row,col+1,vis);
        dfs(grid,row,col-1,vis);
        
    }
}