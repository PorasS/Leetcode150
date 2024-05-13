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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return null;
        }  

        if(root.val == key && root.left == null && root.right == null){
            return null;
        } 

        if(root.left == null && root.right == null && root.val != key){
            return root;
        }

        if(root.val == key && root.left == null && root.right != null){
            TreeNode newRoot = root.right;
            root.right = null;
            return newRoot;
        }

        
        if(root.val == key && root.right == null && root.left != null){
            TreeNode newRoot = root.left;
            root.left = null;
            return newRoot;
        }

        TreeNode nodeToDelete = null;
        TreeNode parentOfKey = null;

        if(root.val == key){
            parentOfKey = root;
            nodeToDelete = root;
        }else{
            parentOfKey = parentOfKey(root, key);
        }
        

        if(parentOfKey == null){//key Not found
            return root;
        }

        
        if(parentOfKey.left != null && parentOfKey.left.val == key){
            nodeToDelete = parentOfKey.left;
        }else if(parentOfKey.right != null && parentOfKey.right.val == key){
            nodeToDelete = parentOfKey.right;
        }

        // case 1: if the node to delete has no children
        if(nodeToDelete.left == null && nodeToDelete.right == null){
            if(parentOfKey.val > nodeToDelete.val){
                parentOfKey.left = null;
            }else{
                parentOfKey.right = null;
            }
        }

        //case 2 : if the node to delete has only one child
        if(nodeToDelete.left == null && nodeToDelete.right != null){
            if(parentOfKey.val > nodeToDelete.val){
                parentOfKey.left = nodeToDelete.right;
            }else{
                parentOfKey.right = nodeToDelete.right;
            }
        }else if(nodeToDelete.left != null && nodeToDelete.right == null){
            if(parentOfKey.val > nodeToDelete.val){
                parentOfKey.left = nodeToDelete.left;
            }else{
                parentOfKey.right = nodeToDelete.left;
            }
        }

        //case 3 : if the nodeToDelete has both the childrens, find the min from right sub tree
        if(nodeToDelete.left != null && nodeToDelete.right != null){
            TreeNode minNode = findMin(nodeToDelete.right);
            nodeToDelete.val = minNode.val;
            TreeNode parentOfMin = parentOfKey(nodeToDelete,  minNode.val);
            if(parentOfMin.left != null && parentOfMin.left.val == minNode.val && 
            minNode.right == null && minNode.left == null){
                parentOfMin.left = null;
            }else if(parentOfMin.right != null && parentOfMin.right.val == minNode.val
            && minNode.right == null && minNode.left == null){
                parentOfMin.right = null;
            } else if(minNode.right != null && parentOfMin.val > minNode.val){
                parentOfMin.left = minNode.right;
            }else {
                parentOfMin.right = minNode.right;
            }
        }

        return root;
    }

    public TreeNode parentOfKey(TreeNode node, int key){
        if(node != null && (node.left != null && node.left.val == key) ||
         (node.right != null && node.right.val == key)){
            return node;
        }

        TreeNode parent = null;
        if(node.val > key && node.left != null){
            parent = parentOfKey(node.left, key);
        }else if(node.right != null){
            parent = parentOfKey(node.right, key);
        }

        return parent;
    }

    public TreeNode findMin(TreeNode node){
        if(node.left == null){
            return node;
        }

        return findMin(node.left);
    }
}
