import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _337_HouseRobberIII {
    Map<TreeNode, Integer> can;
    Map<TreeNode, Integer> cannot;
    public int rob(TreeNode root) {
        can = new HashMap<TreeNode, Integer>();
        cannot = new HashMap<TreeNode, Integer>();
        can.put(null, 0);
        cannot.put(null, 0);
        dp(root);
        return can.get(root);
    }
    public void dp(TreeNode root) {
        if(can.containsKey(root) || cannot.containsKey(root))
            return;
        dp(root.left);
        dp(root.right);
        int tempcan = root.val + cannot.get(root.left) + cannot.get(root.right);
        int tempcannot = can.get(root.left) + can.get(root.right);
        cannot.put(root, tempcannot);
        can.put(root, Math.max(tempcan, tempcannot));
    }
}
