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
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return checkSameTree(p, q);
  }

  public boolean checkSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null && q != null || p != null && q == null) {
      return false;
    }

    boolean left = checkSameTree(p.left, q.left);
    boolean right = checkSameTree(p.right, q.right);

    return (left && right) && (p.val == q.val) ? true : false;
  }
}
