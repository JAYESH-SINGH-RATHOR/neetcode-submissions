/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int diam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dia(root);
        return diam;
    }
    public int dia(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = dia(root.left);
        int rh = dia(root.right);
        diam = Math.max(diam , lh + rh);
        return Math.max(lh , rh ) + 1;
    }
}
