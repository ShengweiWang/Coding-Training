/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length);
    }
    public TreeNode convert(int[] nums, int l, int h){
        if (l >= h)
            return null;
        int mid = l + ((h - l) >> 1);
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = convert(nums, l, mid);
        cur.right = convert(nums, mid + 1, h);
        return cur;
    }

}
