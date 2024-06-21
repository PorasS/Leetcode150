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
  public List < Integer > inorderTraversal(TreeNode root) {

    res = new ArrayList < > ();

    if (root == null) {
      return res;
    }

    inOrderHelper(root);

    return res;
  }

  public void inOrderHelper(TreeNode root) {
    if (root.left != null) {
      inOrderHelper(root.left);
    }
    res.add(root.val);
    if (root.right != null) {
      inOrderHelper(root.right);
    }
  }

}
