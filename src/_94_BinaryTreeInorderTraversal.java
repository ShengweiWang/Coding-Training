import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> leftList = inorderTraversal(root.left);
        leftList.add(root.val);
        List<Integer> rightList = inorderTraversal(root.right);
        leftList.addAll(rightList);
        return leftList;
    }
}
