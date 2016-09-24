import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _272_ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.val >= target){
                succ.push(cur);
                cur = cur.left;
            } else {
                pred.push(cur);
                cur = cur.right;
            }
        }
        for(int i = 0; i < k ; ++i){
            if(pred.isEmpty() && succ.isEmpty())
                break;
            else if (pred.isEmpty())
                res.add(getSuccessor(succ));
            else if (succ.isEmpty())
                res.add(getPredecessor(pred));
            else if (Math.abs(target - (double)pred.peek().val) <= Math.abs((double)succ.peek().val - target))
                res.add(getPredecessor(pred));
            else
                res.add(getSuccessor(succ));
        }
        return res;

    }
    int getPredecessor(Stack<TreeNode> pred){
        TreeNode popped = pred.pop();
        TreeNode cur = popped.left;
        while(cur != null){
            pred.push(cur);
            cur = cur.right;
        }
        return popped.val;
    }
    int getSuccessor(Stack<TreeNode> succ){
        TreeNode popped = succ.pop();
        TreeNode cur = popped.right;
        while(cur != null){
            succ.push(cur);
            cur = cur.left;
        }
        return popped.val;
    }
}
