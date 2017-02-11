/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        
        // key is the vertical column. The list contains the values for that column
        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        
        LinkedList<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        int minCol = 0, maxCol = 0;
        
        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode n = t.n;
            int col = t.col;
            if(col < minCol) minCol = col;
            if(col > maxCol) maxCol = col;
            
            if(!hm.containsKey(col))
                hm.put(col, new ArrayList<Integer>());
            hm.get(col).add(n.val);
                
            if(n.left != null) q.addLast(new Tuple(n.left, col - 1));
            if(n.right != null) q.addLast(new Tuple(n.right, col + 1));
        }
        
        for(int i = minCol; i <= maxCol; i++)
            ret.add(hm.get(i));
        
        return ret;
    }
    
    private class Tuple{
        TreeNode n;
        int col;
        public Tuple(TreeNode nd, int c){
            n = nd;
            col = c;
        }
    }
    
}
