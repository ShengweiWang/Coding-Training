/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _298_BinaryTreeLongestConsecutiveSequence {
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        if(root ==  null)
            return 0;
        int cur = dfs(root);
        if(cur > ans)
            return cur;
        else
            return ans;
    }
    public int dfs(TreeNode root){
        int cur = 1;
        if(root.left != null){
            int l = dfs(root.left);
            if(root.val + 1 == root.left.val)
                cur += l;
            else if (l > ans)
                ans = l;
        }
        if(root.right != null){
            int r = dfs(root.right);
            if(root.val + 1 == root.right.val){
                if(r >= cur)
                    cur = r + 1;
            }
            else if (r > ans)
                ans = r;
        }
        return cur;
    }
}
