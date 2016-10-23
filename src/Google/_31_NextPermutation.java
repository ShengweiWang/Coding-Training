package Google;

/**
 * Created by Shengwei_Wang on 10/19/16.
 */
public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        while (k > 0 && nums[k] <= nums[k-1])
            --k;
        int l = k;
        int r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            ++l;
            --r;
        }
        // System.out.println(k);
        if (k > 0) {
            --k;
            int j = k + 1;
            while (nums[j] <= nums[k])
                ++j;
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
        }
    }
}
