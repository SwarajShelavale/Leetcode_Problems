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
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        preOrder(root,low,high);
        return sum;
    }
    void preOrder(TreeNode root,int low,int high)
    {
        if(root==null)
            return;

        if(root.val<low)
            preOrder(root.right,low,high);
        else if(root.val>high)
            preOrder(root.left,low,high);
        else
        {
            sum+=root.val;
            preOrder(root.left,low,high);
            preOrder(root.right,low,high);
        }
    }
}