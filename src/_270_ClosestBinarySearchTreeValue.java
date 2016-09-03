/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _270_ClosestBinarySearchTreeValue {
    int ans;
    double target;
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return 0;
        ans = root.val;
        this.target = target;
        if(target > root.val)
            dfs(root.right);
        else
            dfs(root.left);
        return ans;
    }
    public void dfs(TreeNode root) {
        if(root == null)
            return;
        if(target > root.val){
            if(target - root.val < Math.abs(ans - target))
                ans = root.val;
            dfs(root.right);
        } else {
            if(root.val - target < Math.abs(ans - target))
                ans = root.val;
            dfs(root.left);
        }
    }
}
