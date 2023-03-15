class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[]indegree = new int[numCourses];
        Queue<Integer>queue = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        int m = prerequisites.length;
        
        for(int i = 0; i<m; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //just calculate the indegree of vertices
        for(int i = 0; i<numCourses;i++){
            for(int u:adj.get(i)){
                indegree[u]++;
            }
        }

        //if indegree of vertices is zero then add it into queue
        for(int i = 0; i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            topo.add(node);

            for(int u:adj.get(node)){
                indegree[u]--;
                if(indegree[u] == 0){
                    queue.add(u);
                }
            }
        }

        if(topo.size() == numCourses){
            return true;
        }
        return false;
    }
}