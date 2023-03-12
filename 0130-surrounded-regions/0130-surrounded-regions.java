class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean[][] vis = new boolean[n][m];

        // for first and last row
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' && vis[0][i] == false) {
                dfs(board, dir, vis, 0, i);
            }

            if (board[n - 1][i] == 'O' && vis[n - 1][i] == false) {
                dfs(board, dir, vis, n - 1, i);
            }
        }

        // for first and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && vis[i][0] == false) {
                dfs(board, dir, vis, i, 0);
            }
            if (board[i][m - 1] == 'O' && vis[i][m - 1] == false) {
                dfs(board, dir, vis, i, m - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j] ==false && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int[][] dir, boolean[][] vis, int row, int col) {
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && board[newRow][newCol] == 'O'
                    && vis[newRow][newCol] == false) {
                dfs(board, dir, vis, newRow, newCol);
            }
        }
    }
}