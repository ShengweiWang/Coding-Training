import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 11/5/16.
 */
public class _95_UniqueBinarySearchTree {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();
        return helper(1, n);
    }
    public List<TreeNode> helper (int l, int r) {
        List<TreeNode> ans = new LinkedList<>();
        if (l > r) {
            ans.add(null);
            return ans;
        }
        if (l == r) {
            ans.add(new TreeNode(l));
            return ans;
        }
        for (int i = l; i <= r; ++i) {
            List<TreeNode> llist = helper(l, i - 1);
            List<TreeNode> rlist = helper(i + 1, r);
            for (TreeNode ll : llist)
                for (TreeNode rr : rlist) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = ll;
                    curr.right = rr;
                    ans.add(curr);
                }
        }
        return ans;
    }
}
