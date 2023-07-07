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
  PriorityQueue < Integer > list = null;
  public int kthSmallest(TreeNode root, int k) {
    list = new PriorityQueue < > ();
    traverseNodes(root);

    int i = 1;
    while (i != k) {
      list.poll();
      i++;
    }

    return list.poll();
  }

  public void traverseNodes(TreeNode root) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    traverseNodes(root.left);
    traverseNodes(root.right);
  }
}
