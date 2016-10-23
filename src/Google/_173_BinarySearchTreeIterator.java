package Google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shengwei_Wang on 10/19/16.
 */
public class _173_BinarySearchTreeIterator {
    Deque<TreeNode> stack;
    public _173_BinarySearchTreeIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (stack.size() > 0);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int ans = curr.val;
        curr = curr.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return ans;
    }
}
