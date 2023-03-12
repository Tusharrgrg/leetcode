class Solution {
    
   static public int[][] updateMatrix(int[][] mat) {
       int n=mat.length;
       int m=mat[0].length;
       int dis[][]=new int[n][m];
       boolean[][]vis = new boolean[n][m];
       
       bfs(mat,vis,dis);

      
        return dis;
        
    }
    
    
    public static void bfs(int[][]mat, boolean[][]vis, int[][]dis){

        Queue<int[]>pq = new LinkedList<>();

        for(int i = 0; i<mat.length; i++){
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0){
                    pq.add(new int[]{i,j,0});
                    vis[i][j] = true;
                    dis[i][j] = 0;
                }
            }
        }
        int di = 0;
        while(!pq.isEmpty()){
            int [] arr = pq.remove();
            int row = arr[0];
            int col = arr[1];
            int d = arr[2];
            dis[row][col] = d;
            di = Math.max(di, d);

            for(int i = -1; i<2;i++){
                for(int j = -1; j<2; j++){
                    if(Math.abs(i)!=Math.abs(j)){
                        int newRow = row+i;
                        int newCol = col+j;

                        if(newRow>=0 && newCol>=0 &&newRow<mat.length&&newCol<mat[0].length&&!vis[newRow][newCol]){
                            pq.add(new int[] { newRow, newCol, d + 1 });
                            vis[newRow][newCol] = true;
                        }
                        
                    }
                }
            }
        }

    }
}