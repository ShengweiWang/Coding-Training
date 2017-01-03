package Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 11/2/16.
 */
public class _297_SerializeAndDeserializeBinaryTree {
        final String spliter = ",";
        final String nullPointer = "X";

        public _297_SerializeAndDeserializeBinaryTree(){
        }
        public String serialize(TreeNode root) {
            if (root == null)
                return nullPointer + spliter;
            StringBuilder sb = new StringBuilder();
            sb.append(root.val).append(spliter);
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));
            return sb.toString();
        }
        public TreeNode deserialize(String data) {
            Queue<String> q = new LinkedList<>();
            q.addAll(Arrays.asList(data.split(spliter)));
            return buildTree(q);
        }
        TreeNode buildTree(Queue<String> q) {
            if (q.size() == 0)
                return null;
            String curr = q.poll();
            if (curr.compareTo(nullPointer) == 0)
                return null;
            TreeNode root = new TreeNode(Integer.valueOf(curr));
            root.left = buildTree(q);
            root.right = buildTree(q);
            return root;

        }

}
