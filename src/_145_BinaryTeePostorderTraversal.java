import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _145_BinaryTeePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> state = new Stack<>();
        stack.push(root);
        state.push(0);
        while(stack.size() > 0){
            TreeNode cur = stack.peek();
            if(state.peek() == 0){
                if(cur.left != null){
                    state.pop();
                    state.push(1);
                    stack.push(cur.left);
                    state.push(0);
                } else {
                    state.pop();
                    state.push(1);
                }
            } else if(state.peek() == 1 && cur.right != null) {
                state.pop();
                state.push(2);
                stack.push(cur.right);
                state.push(0);
            } else {
                stack.pop();
                state.pop();
                res.add(cur.val);
            }
        }
        return res;
    }
}
