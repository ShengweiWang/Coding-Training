import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 9/19/16.
 */
public class _297_SerializeAndDeserializeBinaryTree {

    String spliter;
    String nullPointer;
    StringBuilder sb;
    public _297_SerializeAndDeserializeBinaryTree(){
        spliter = ",";
        nullPointer = "X";
        sb = new StringBuilder();
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        builds(root);
        return sb.toString();
    }

    void builds (TreeNode root){
        if(root == null){
            sb.append(nullPointer).append(spliter);
        } else {
            sb.append(root.val).append(spliter);
            builds(root.left);
            builds(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(spliter)));
        return buildtree(q);
    }
    TreeNode buildtree(Queue<String> q){
        if(q.size() == 0)
            return null;
        String cur = q.poll();
        if(cur.equals(nullPointer))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = buildtree(q);
        root.right = buildtree(q);
        return root;
    }
}
