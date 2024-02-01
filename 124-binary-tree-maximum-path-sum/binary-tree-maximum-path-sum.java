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
    int maxPath=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
      
        findMaxPathSum(root);
        return maxPath;
    }

    int findMaxPathSum(TreeNode  root)
    {
        if(root.left==null && root.right==null)
        {
            maxPath=Math.max(maxPath,root.val);
            return root.val;
        }
        int leftPathSum=0;
        int rightPathSum=0;
        if(root.left!=null)
            leftPathSum = Math.max(0,findMaxPathSum(root.left));
        if(root.right!=null)
            rightPathSum = Math.max(0,findMaxPathSum(root.right));

        maxPath=Math.max(maxPath,root.val+leftPathSum+rightPathSum);
        return root.val+Math.max(leftPathSum,rightPathSum);
    }
}