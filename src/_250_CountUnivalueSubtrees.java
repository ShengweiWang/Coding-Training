/**
 * Created by Shengwei_Wang on 9/13/16.
 */
public class _250_CountUnivalueSubtrees {
    int ans;
    public int countUnivalSubtrees(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    public boolean dfs(TreeNode root){
        if(root == null)
            return true;
        boolean f = true;
        if((root.left != null && root.val != root.left.val) || root.right != null && root.right.val != root.val)
            f = false;
        if(!dfs(root.left))
            f = false;
        if(!dfs(root.right))
            f = false;
        if(f)
            ++ans;
        return f;
    }
}
