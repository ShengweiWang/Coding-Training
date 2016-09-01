/**
 * Created by Shengwei_Wang on 8/31/16.
 */
public class _129_SomRootToLeafNumbers {
    int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }
    public void dfs(TreeNode root, int val){
        if(root == null)
            return;
        val = val * 10 + root.val;
        if(root.left == null && root.right == null){
            ans += val;
            return;
        } else {
            dfs(root.left, val);
            dfs(root.right, val);
        }
    }
}
