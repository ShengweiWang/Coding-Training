package Google;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _298_BinaryTreeLongestConsecutiveSequence {
    int max;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    int dfs (TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int ans = 1;
        if (l != 0 && root.left.val == root.val + 1)
            ans = Math.max(ans, l + 1);
        if (r != 0 && root.right.val == root.val + 1)
            ans = Math.max(ans, r + 1);
        max = Math.max(max, ans);
        return ans;
    }
}
