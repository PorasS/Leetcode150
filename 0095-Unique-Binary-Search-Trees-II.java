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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int l, int r){
        
        if(l > r){
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        for(int i = l; i <= r; i++){
            List<TreeNode> left = helper(l, i-1);
            List<TreeNode> right = helper(i+1, r);

            for(TreeNode ln : left){
                for(TreeNode rn : right){
                    TreeNode node = new TreeNode(i, ln, rn);
                    nodeList.add(node);
                }
            }
        }
        return nodeList;
    }
}
