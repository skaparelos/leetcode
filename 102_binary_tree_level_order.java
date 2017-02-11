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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null)
            return ret;

        LinkedList<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        
        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode n = t.tn;
            int depth = t.depth;
            
            if (ret.size() == 0 || ret.size() -1 < depth || ret.get(depth) == null)
                ret.add(new ArrayList<Integer>());
            ret.get(depth).add(n.val);
            
            if(n.left != null)
                q.addLast(new Tuple(n.left, depth + 1));
            if(n.right != null)
                q.addLast(new Tuple(n.right, depth + 1));
        }
        
        return ret;
    }
    
    private class Tuple{
        TreeNode tn;
        int depth;
        public Tuple(TreeNode t, int d){
            tn = t;
            depth = d;
        }
    }
}
