package Google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 11/1/16.
 */
public class _315_C {
    class BST {
        class TreeNode {
            int val;
            int self;
            int count;
            TreeNode left, right;
            public TreeNode (int val) {
                this.val = val;
                this.self = 1;
                this.count = 0;
            }
        }
        TreeNode root = null;


        public int insert (int val) {
            int ans = 0;
            if (root == null) {
                root = new TreeNode (val);
                return 0;
            } else {

                TreeNode curr = root;
                while (curr.val != val) {
                    if (curr.val > val ) {
                        ans += curr.self + curr.count;
                        if (curr.left == null ){
                            curr.left = new TreeNode(val);
                            return ans;
                        } else {
                            curr = curr.left;
                        }
                    } else {
                        ++curr.count;
                        if (curr.right != null) {
                            curr.right = new TreeNode(val);
                            return ans;
                        } else {
                            curr = curr.right;
                        }
                    }
                }
                curr.self++;
                return ans + curr.count;
            }
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        BST bst = new BST();
        List<Integer> ans = new LinkedList<>();
        for (int num : nums){
            ans.add(bst.insert(num));
        }
        return ans;
    }

}
