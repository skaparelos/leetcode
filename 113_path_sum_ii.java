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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null){
            //ArrayList<Integer> ar = new ArrayList<Integer>();
            //ret.add(ar);
            return ret;
        }
        ArrayList<Integer> ar = new ArrayList<Integer>();
        calcSums(root, ret, ar, sum, 0);
        return ret;
    }
    
    public void calcSums(TreeNode n, List<List<Integer>> l, ArrayList<Integer> temp , int target, int curSum){
        if (n == null) return;

        curSum += n.val;
        temp.add(n.val);
        //System.out.println("temp = " + temp);
        if (curSum == target && n.right == null && n.left == null) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            a.addAll(temp);
            l.add(a);
        }
        
        calcSums(n.left, l, temp, target, curSum);
        calcSums(n.right, l, temp, target, curSum);
        
        curSum -= n.val;
        temp.remove(temp.size() - 1);
        
    }
}
