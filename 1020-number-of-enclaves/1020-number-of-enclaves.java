class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][]vis = new boolean[n][m];
        int[][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for(int i = 0;i<n;i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(grid,vis,dir,i,0);
            }
            
            if(grid[i][m-1] == 1 && !vis[i][m-1]){
                dfs(grid,vis,dir,i,m-1);
            }
        }
        
        for(int i = 0;i<m;i++){
            if(grid[0][i] == 1 && !vis[0][i]){
                dfs(grid,vis,dir,0,i);
            }
            
            if(grid[n-1][i] == 1 && !vis[n-1][i]){
                dfs(grid,vis,dir,n-1,i);
            }
        }
        int count = 0;
        for(int i =0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(grid[i][j] == 1&&!vis[i][j]){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static void dfs(int[][]grid,boolean[][]vis,int[][]dir,int row,int col){
        vis[row][col] = true;
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i<4;i++){
            int newRow = row+dir[i][0];
            int newCol = col+dir[i][1];
            
            if(newRow>=0&&newCol>=0&&newRow<n&&newCol<m&&vis[newRow][newCol]==false&&grid[newRow][newCol] ==1){
                dfs(grid,vis,dir,newRow,newCol);
            }
        }
    }
}