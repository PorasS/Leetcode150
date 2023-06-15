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
  List < List < Integer >> resList = new ArrayList < > ();
  List < TreeNode > queue = null;
  public List < List < Integer >> levelOrder(TreeNode root) {
    queue = new LinkedList < > ();
    if (root == null) {
      return resList;
    }

    if (root != null) {
      List < Integer > list = new ArrayList < > ();
      list.add(root.val);
      resList.add(list); //[[3]]
      queue.add(root);
    }

    bfs();

    return resList;

  }

  public void bfs() {
    List < Integer > list = new ArrayList < > ();
    List < TreeNode > newQueue = new LinkedList < > ();
    if (queue.isEmpty()) {
      return;
    }
    while (!queue.isEmpty()) {
      TreeNode node = queue.get(0);
      if (node.left != null) {
        list.add(node.left.val);
        newQueue.add(node.left);
      }
      if (node.right != null) {
        list.add(node.right.val);
        newQueue.add(node.right);
      }
      queue.remove(0);
    }
    //[9,20] [15,7]
    //[[3] []]
    queue = newQueue;
    if (!list.isEmpty()) {
      resList.add(list);
    }
    //[[3],[9,20],[15,7]]     
    bfs();
  }

}
