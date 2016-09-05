import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _257_BinaryTreePaths {
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<String>();
        if(root == null)
            return ans;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            ans.add(sb.toString());
            return ans;
        }
        if(root.left != null)
            dfs(root.left, new StringBuilder(sb));
        if(root.right != null)
            dfs(root.right, new StringBuilder(sb));
        return ans;
    }
    public void dfs(TreeNode root, StringBuilder sb){
        sb.append("->").append(root.val);
        if(root.left == null && root.right == null){
            ans.add(sb.toString());
            return;
        }
        if(root.left != null)
            dfs(root.left, new StringBuilder(sb));
        if(root.right != null)
            dfs(root.right, new StringBuilder(sb));
    }
}
