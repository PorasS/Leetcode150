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
  int res = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    diameter(root);
    return res;
  }

  public int diameter(TreeNode node) {
    if (node == null) {
      return -1;
    }

    int leftLength = diameter(node.left);
    int rightLength = diameter(node.right);
    res = Math.max(res, leftLength + rightLength + 2);

    return Math.max(leftLength, rightLength) + 1;
  }
}
