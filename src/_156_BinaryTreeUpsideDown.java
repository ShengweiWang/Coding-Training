/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _156_BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode newRoot = dfs(root);
        root.left = null;
        root.right = null;
        return newRoot;
    }
    public TreeNode dfs(TreeNode root){
        if(root.left == null)
            return root;
        TreeNode newRoot = dfs(root.left);
        root.left.left = root.right;
        root.left.right = root;
        return newRoot;
    }
}
