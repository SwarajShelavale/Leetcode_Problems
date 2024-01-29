/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        BuildString(root,res);
        return res.toString();
    }

    void BuildString(TreeNode root,StringBuilder res)
    {
        if(root==null)
        {
            res.append("X").append(",");
        }
        else
        {
            res.append(root.val).append(",");
            BuildString(root.left,res);
            BuildString(root.right,res);
        }
     }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));

        return BuildTree(nodes);
    }

    TreeNode BuildTree(Deque<String> nodes )
    {
        String val = nodes.remove();
        if(val.equals("X"))
            return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left=BuildTree(nodes);
        node.right=BuildTree(nodes);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));