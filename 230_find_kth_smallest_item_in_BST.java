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
    
    boolean found = false;
    int kthSmallest = -1;
    int kth = 0;
    public int kthSmallest(TreeNode root, int k) {
        findkth(root, k);
        return kthSmallest;
    }
    
    public void findkth(TreeNode n, int k){
        if (n == null) return;
        if(found) return;
        
        findkth(n.left, k);
        kth++;
        //System.out.println("At " + n.val + ", kth = " + kth);
        if( kth == k ){
            found = true;
            kthSmallest = n.val;
        }
        findkth(n.right, k);
    }
}
