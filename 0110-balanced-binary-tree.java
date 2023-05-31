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
  public boolean isBalanced(TreeNode root) {
    try {
      if (root == null) {
        return true;
      }

      int left = heightBalancedCheck(root.left);
      int right = heightBalancedCheck(root.right);

      if (Math.abs(left - right) > 1) {
        return false;
      } else {
        return true;
      }
    } catch (Exception e) {
      return false;
    }

  }

  public int heightBalancedCheck(TreeNode root) throws Exception {
    if (root == null) {
      return 0;
    }

    int leftHeight = heightBalancedCheck(root.left);
    int rightHeight = heightBalancedCheck(root.right);

    if (Math.abs(leftHeight - rightHeight) > 1) {
      throw new Exception("Not Balanced");
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
