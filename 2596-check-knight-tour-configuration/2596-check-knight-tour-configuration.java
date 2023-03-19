class Solution {
    public boolean checkValidGrid(int[][] grid) {
     
        int[] dRow = {-2, -2, 2, 2, 1, -1, -1, 1}; // rows for 8 moves
        int[] dCol = {1, -1, 1, -1, -2, -2, 2, 2}; // columns for 8 moves 
        int m = grid.length;
        // int n = grid[0].length;
        boolean[] visited = new boolean[m * m];
        helper(0, 0, grid, m, dRow, dCol, visited);

        for(int i = 0; i < m * m; i++) {
            if(!visited[i]) return false; // check if all were visited
        }
        return true;
    }
    
    void helper(int row, int col, int[][] arr, int m, int[] dRow, int[] dCol, boolean[] visited) {
        int curr_val = arr[row][col];
        visited[curr_val] = true;
        for(int i = 0; i < 8; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            // checking if value is present and if position is in bounds
            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < m && arr[nRow][nCol] == curr_val + 1) { 
                helper(nRow, nCol, arr, m, dRow, dCol, visited);
            }
        }
    }
}