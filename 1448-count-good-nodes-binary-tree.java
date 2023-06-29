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

  List < Integer > res = null;
  public int goodNodes(TreeNode root) {
    res = new ArrayList < > ();
    countGoodNodes(root, root.val);
    return res.size();
  }

  public void countGoodNodes(TreeNode node, int val) {
    if (node == null) {
      return;
    }

    if (node.val >= val) {
      res.add(val);
    }

    if (node.left != null) {
      countGoodNodes(node.left, Math.max(node.val, val));
    }

    if (node.right != null) {
      countGoodNodes(node.right, Math.max(node.val, val));
    }
  }
}
