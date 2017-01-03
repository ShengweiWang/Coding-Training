package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/25/16.
 */
public class _314_BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q_node = new LinkedList<>();
        Queue<Integer> q_index = new LinkedList<>();
        if (root != null) {
            q_node.offer(root);
            q_index.offer(0);
        }
        while (!q_node.isEmpty()) {
            TreeNode node = q_node.poll();
            int index = q_index.poll();
            min = Math.min(min, index);
            max = Math.max(max, index);
            if (!map.containsKey(index))
                map.put(index, new LinkedList<>());
            map.get(index).add(node.val);
            if (node.left != null) {
                q_node.offer(node.left);
                q_index.offer(index - 1);
            }
            if (node.right != null) {
                q_node.offer(node.right);
                q_index.offer(index + 1);
            }
        }

        List<List<Integer>> ans = new LinkedList<>();
        for (int key = min; key <= max; ++key) {
            ans.add(map.get(key));
        }
        return ans;
    }


}
