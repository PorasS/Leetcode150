https://leetcode.com/problems/validate-binary-search-tree/description/
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
    public boolean isValidBST(TreeNode root) {
      return validBST(root.left, Integer.MIN_VALUE, root.val) && validBST(root.right, root.val, Integer.MAX_VALUE);
    }

    public boolean validBST(TreeNode node, int l, int h){

        if(node == null){
            return true;
        }

        if(node.val >= h || node.val <= l){
            return false;
        }

        return  validBST(node.left, l, node.val) && validBST(node.right, node.val, h);

    }
}
