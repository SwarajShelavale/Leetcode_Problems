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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafSequence1 = new ArrayList<>();
        ArrayList<Integer> leafSequence2 = new ArrayList<>();
        inOrder(root1,leafSequence1);
        inOrder(root2,leafSequence2);

        if(leafSequence1.equals(leafSequence2))
            return true;
        return false;
        
    }

    void inOrder(TreeNode root, ArrayList<Integer> leafSequence)
    {
        if(root==null)
            return;

        inOrder(root.left,leafSequence);   
        if(root.left==null && root.right==null)
            leafSequence.add(root.val);
        inOrder(root.right,leafSequence);
    }

}