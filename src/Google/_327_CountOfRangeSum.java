package Google;

/**
 * Created by Shengwei_Wang on 11/1/16.
 */


public class _327_CountOfRangeSum {
    class BST {
        class TreeNode {
            long val;
            int self;
            int count;
            TreeNode left, right;

            public TreeNode(long val) {
                this.val = val;
                this.self = 1;
                this.count = 0;
            }
        }

        TreeNode root = null;


        public void insert(long val) {
            if (root == null) {
                root = new TreeNode(val);
                return;
            } else {


                TreeNode curr = root;
                while (curr.val != val) {
                    if (curr.val > val) {
                        ++curr.count;
                        if (curr.left == null) {
                            curr.left = new TreeNode(val);
                            return;
                        } else {
                            curr = curr.left;
                        }
                    } else {
                        if (curr.right == null) {
                            curr.right = new TreeNode(val);
                            return;
                        } else {
                            curr = curr.right;
                        }
                    }
                }
                curr.self++;
            }
        }

        public int larger(long val) {
            TreeNode curr = root;
            int ans = 0;
            while (curr != null) {
                if (curr.val == val)
                    return ans + curr.count;
                else if (curr.val > val) {
                    curr = curr.left;
                } else {
                    ans += curr.self + curr.count;
                    curr = curr.right;
                }
            }
            return ans;
        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        BST bst = new BST();
        long sum = 0;
        bst.insert(0);
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            ans += (bst.larger(sum - lower + 1) - bst.larger(sum - upper));
            bst.insert(sum);
        }
        return ans;

    }

}
