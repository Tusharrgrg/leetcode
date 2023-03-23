class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        int[][]dis = new int[n][n];
        for(int[]a:dis){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        if(grid[0][0]!= 0)return -1;
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{1,0,0});
        dis[0][0] = 1;
        grid[0][0] = 1;
        if(n == 1)return 1;
        
        while(!q.isEmpty()){
            int[] a = q.peek();
            q.remove();
            int d = a[0];
            int row = a[1];
            int col = a[2];
            
            
            for(int i = -1; i<2; i++){
                for(int j = -1; j<2; j++){
                    int newRow = row+i;
                    int newCol = col+j;
                    
                    if(newRow>=0 && newCol>=0 && newRow<n && newCol<n && grid[newRow][newCol]==0){
                        
                        if(newRow == n-1 && newCol == n-1)return d+1;
                        if(dis[newRow][newCol]>d+1){
                            dis[newRow][newCol] = d+1;
                            q.add(new int[]{d+1, newRow,newCol});
                            grid[newRow][newCol] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}