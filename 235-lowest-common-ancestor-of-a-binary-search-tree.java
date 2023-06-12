/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
  TreeNode lca;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val < q.val) {
      return lca(root, p, q);
    } else {
      return lca(root, q, p);
    }
  }

  public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val <= root.val && q.val >= root.val) {
      return root;
    }
    if (p.val == root.val) {
      return root;
    }
    TreeNode node = null;
    if (root.left != null && p.val <= root.val && q.val <= root.val) {
      node = lca(root.left, p, q);
    } else if (root.right != null) {
      node = lca(root.right, p, q);
    }
    return node;
  }

}
