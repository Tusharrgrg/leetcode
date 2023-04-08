// Facebook
// 
// Amazon
// 
// Bloomberg
// 
// Google
// 
// Microsoft
// 
// Pinterest
// 

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null)return null;
        
        Node clone  = new Node(node.val);
        
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node,clone);
        dfs(node,clone,map);
        
        return clone;
        
    }
    
    public static void dfs(Node node, Node clone, HashMap<Node,Node> map){
        for(Node n : node.neighbors){
            if(!map.containsKey(n)){
                Node c = new Node(n.val);
                map.put(n,c);
                clone.neighbors.add(c);
                dfs(n,c,map);
            }else{
                clone.neighbors.add(map.get(n));
            }
        }
    }
}