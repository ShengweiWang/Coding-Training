/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _112_PathSum {
    boolean has;
    public boolean hasPathSum(TreeNode root, int sum) {
        has = false;
        dfs(root, sum);
        return has;
    }
    public void dfs(TreeNode root, int sum){
        if(has || root == null)
            return;
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) {
            has = true;
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
