package hashmap;


import java.util.*;

/**
 * Created by Shengwei_Wang on 9/28/16.
 */
public class _314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int max;
        int min;
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> q1 = new LinkedList<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        max = -1;
        min = 1;
        q.offer(root);
        q1.offer(0);
        while(q.size() > 0){
            TreeNode cur = q.poll();
            int m = q1.poll();
            if(m > max)
                max = m;
            if (m < min)
                min = m;
            if(!map.containsKey(m)){
                map.put(m, new LinkedList<Integer>());
            }
            map.get(m).add(cur.val);
            if(cur.left!= null){
                q.offer(cur.left);
                q1.offer(m-1);
            }
            if(cur.right!= null){
                q.offer(cur.right);
                q1.offer(m+1);
            }
        }
        for(int i = min; i <= max; ++i){
            ans.add(map.get(i));
        }
        return ans;
    }
}
