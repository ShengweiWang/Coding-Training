import java.util.Stack;

/**
 * Created by Shengwei_Wang on 8/22/16.
 */
public class _104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return recursiveDepth(root);
    }

    public int recursiveDepth(TreeNode root){
        if (root == null)
            return 0;
        int l_d = recursiveDepth(root.left);
        int r_d = recursiveDepth(root.right);
        if(l_d >= r_d)
            return l_d + 1;
        else
            return r_d + 1;
    }
}
