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
    int maxDifferance = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
            return 0;
        int minVal=root.val,maxVal=root.val;
        prefix(root,minVal,maxVal);
        return maxDifferance;
    }

    void prefix(TreeNode root,int minVal,int maxVal)
    {
        if(root==null)
            return ;
        
        maxDifferance = Math.max(maxDifferance,Math.max(Math.abs(minVal-root.val),Math.abs(maxVal-root.val)));

        minVal=Math.min(minVal,root.val);
        maxVal=Math.max(maxVal,root.val);


        prefix(root.left,minVal,maxVal);
        prefix(root.right,minVal,maxVal);
    }
}

