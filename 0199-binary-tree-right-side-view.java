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

  List < TreeNode > queue = null;
  List < Integer > res = null;
  public List < Integer > rightSideView(TreeNode root) {
    queue = new LinkedList < > ();
    res = new ArrayList < > ();
    if (root == null) {
      return res;
    }
    queue.add(root);
    rightView(queue);
    return res;
  }

  public void rightView(List < TreeNode > queue) {

    if (queue.isEmpty()) {
      return;
    }

    List < TreeNode > newQueue = new LinkedList < > ();
    res.add(queue.get(0).val);
    for (TreeNode node: queue) {
      if (node.right != null) {
        newQueue.add(node.right);
      }

      if (node.left != null) {
        newQueue.add(node.left);
      }
    }

    rightView(newQueue);
  }

}
