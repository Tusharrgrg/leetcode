class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][]diff = new int[n][m];
        
        for(int []i : diff){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{0,0,0});
        
        diff[0][0] = 0;
        int [] r = {-1,0,1,0};
        int [] c = {0,1,0,-1};
        while(!pq.isEmpty()){
            int[] node = pq.peek();
            pq.remove();
            
            int di = node[0];
            int row = node[1];
            int col = node[2];
            if(row == n-1 && col == m-1)return di;
            
            for(int i = 0; i<4 ;i++){
                int newRow = row+r[i];
                int newCol = col+c[i];
                if(newRow>=0 && newCol >=0 && newRow<n && newCol<m){
                    int newD = Math.abs(heights[row][col] - heights[newRow][newCol]);
                    int max = Math.max(newD,di);
                    if(max<diff[newRow][newCol]){
                        diff[newRow][newCol] = max;
                        pq.add(new int[]{max , newRow,newCol});
                    }
                }
            }
            
        }
        
//         for(int []a: diff){
//             System.out.println(Arrays.toString(a));
//         }
        
        return 0;
    }
}