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
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {

    if (root == null && subRoot == null) {
      return true;
    }
    return checkSubTree(root, subRoot);
  }

  public boolean checkSubTree(TreeNode root, TreeNode subRoot) {

    if (root == null && subRoot == null) {
      return true;
    }

    if (root == null && subRoot != null || root != null && subRoot == null) {
      return false;
    }

    if (sameTree(root, subRoot)) {
      return true;
    }

    return checkSubTree(root.left, subRoot) || checkSubTree(root.right, subRoot) ? true : false;
  }

  public boolean sameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if ((p == null && q != null) || (p != null && q == null)) {
      return false;
    }
    return sameTree(p.left, q.left) && sameTree(p.right, q.right) && (p.val == q.val) ? true : false;
  }
}
