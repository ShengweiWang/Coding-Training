import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/15/16.
 */
public class _366_FindLeavesOfBinaryTree {
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        height(root);
        return res;
    }

    int height(TreeNode root){
        if(root == null)
            return 0;
        int cur = Math.max(height(root.left), height(root.right)) + 1;
        if(cur > res.size())
            res.add(new ArrayList<>());
        res.get(cur - 1).add(root.val);
        return cur;
    }
}
