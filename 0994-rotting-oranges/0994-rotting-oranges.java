class Solution {
    
    public int orangesRotting(int[][] grid) {        
        boolean[][]vis = new boolean[grid.length][grid[0].length];
        int ans = rotTime(grid,vis);
        return ans;
    }
    
    public static int rotTime(int[][] grid, boolean[][] vis) {

        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j, 0 });
                    vis[i][j] = true;
                } else {
                    vis[i][j] = false;
                }
                if (grid[i][j] == 1) {
                    countFresh += 1;
                }
            }
        }
        int t = 0;
        int count = 0;

        while (!q.isEmpty()) {
            int[] arr = q.remove();
            int row = arr[0];
            int col = arr[1];
            int time = arr[2];

            t = Math.max(t, time);

            for (int rowdir = -1; rowdir < 2; rowdir++) {
                for (int coldir = -1; coldir < 2; coldir++) {
                    if (Math.abs(coldir) != Math.abs(rowdir)) {
                        int newRow = row + rowdir;
                        int newCol = col + coldir;

                        if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                                && !vis[newRow][newCol] && grid[newRow][newCol] == 1) {
                            q.add(new int[] { newRow, newCol, time + 1 });
                            vis[newRow][newCol] = true;
                            count++;
                        }
                    }
                }
            }

        }
        if (count != countFresh)
            return -1;
        return t;
    }
}



//using just given matrix
//         if(grid == null || grid.length == 0) {
//             return 0;
//         }
        
//         int rows = grid.length;
//         int cols = grid[0].length;
        
//         Queue<int[]> queue = new LinkedList<>();
        
//         int count_fresh = 0;
        
//         for(int i = 0 ; i < rows ; i++) {
//             for(int j = 0 ; j < cols ; j++) {
//                 if(grid[i][j] == 2) {
//                     queue.offer(new int[]{i , j});
//                 }
//                 else if(grid[i][j] == 1) {
//                     count_fresh++;
//                 }
//             }
//         }
       
//         if(count_fresh == 0) {
//             return 0;
//         }
        
//         int count = 0;
//         int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
//         //bfs starting from initially rotten oranges
//         while(!queue.isEmpty()) {
//             ++count;
//             int size = queue.size();
//             for(int i = 0 ; i < size ; i++) {
//                 int[] point = queue.poll();
//                 for(int dir[] : dirs) {
//                     int x = point[0] + dir[0];
//                     int y = point[1] + dir[1];
                    
//                     if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2){
//                         continue;  
//                     } 
                    
//                     //mark the orange at (x , y) as rotten
//                     grid[x][y] = 2;
//                     //put the new rotten orange at (x , y) in queue
//                     queue.offer(new int[]{x , y});
//                     //decrease the count of fresh oranges by 1
//                     count_fresh--;
//                 }
//             }
//         }
//         return count_fresh == 0 ? count-1 : -1;