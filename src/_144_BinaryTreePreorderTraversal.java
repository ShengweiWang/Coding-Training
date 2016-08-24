import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> self = new ArrayList<Integer>();
        if(root == null)
            return self;
        else
            self.add(root.val);
        self.addAll(preorderTraversal(root.left));
        self.addAll(preorderTraversal(root.right));
        return self;
    }
}
