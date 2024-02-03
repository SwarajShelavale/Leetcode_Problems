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
        if(root==null)
            return null;
        
        if(root.val==key)
            return helper(root);
        
        TreeNode dummyNode = root;
        while(root!=null)
        {
            if(key < root.val)
            {
                if(root.left!=null && root.left.val==key)
                {
                    root.left= helper(root.left);
                    break;
                }
                root=root.left;
            }
            else
            {   
                if(root.right!=null && root.right.val==key)
                {
                    root.right = helper(root.right);
                    break;
                }
                root=root.right;
            }
        }

        return dummyNode;
    }


    TreeNode helper(TreeNode root)
    {
        if(root.left==null)
            return root.right;
        
        if(root.right==null)
            return root.left;
        
        TreeNode dummyNode = root.left;

        TreeNode rightChild = root.right;

        TreeNode rightmostLeftChild = findChild(root.left);

        rightmostLeftChild.right = rightChild;

        return dummyNode;
    }

    TreeNode findChild(TreeNode root)
    {
        if(root.right==null)
            return root;
            
        return findChild(root.right);
    }
}