/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(l == -1 || r == -1 || l - r > 1 || r - l > 1)
            return -1;
        if(l > r)
            return l + 1;
        else
            return r + 1;
    }
}
