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
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{ // equal
            if(root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            
            TreeNode n = getMaxMin(root.right);
            root.val = n.val;
            // delete the node with the value root.val
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    public TreeNode getMaxMin(TreeNode n){
        while(n.left != null)
            n = n.left;
        return n;
    }
}
