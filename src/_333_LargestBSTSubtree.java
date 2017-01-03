/**
 * Created by Shengwei_Wang on 11/7/16.
 */
public class _333_LargestBSTSubtree {
    int ans;
    public int largestBSTSubtree(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    public Res helper (TreeNode root) {
        if (root == null)
            return new Res(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Res resl = helper(root.left);
        Res resr = helper(root.right);
        if (resl.num == -1 || resr.num == -1 || resl.max >= root.val || resr.min <= root.val)
            return new Res(0, 0, -1);
        ans = Math.max(ans, resl.num + resr.num + 1);
        return new Res(Math.min(root.val, resl.min), Math.max(root.val, resr.max), resl.num + resr.num + 1);


    }

    class Res {
        int min;
        int max;
        int num;
        public Res(int min, int max, int num){
            this.min = min;
            this.max = max;
            this.num = num;
        }
    }
}
