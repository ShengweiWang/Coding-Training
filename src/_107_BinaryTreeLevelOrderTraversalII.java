import java.util.*;

/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)
            return ans;
        q.offer(root);
        while(q.size() != 0){
            List<Integer> curl = new ArrayList<>();
            Queue<TreeNode> p = new ArrayDeque<TreeNode>();
            while(q.size() != 0){
                TreeNode cur = q.poll();
                curl.add(cur.val);
                if(cur.left != null)
                    p.offer(cur.left);
                if(cur.right != null)
                    p.offer(cur.right);
            }
            ans.add(0, curl);
            q = p;
        }
        return ans;
    }
}
