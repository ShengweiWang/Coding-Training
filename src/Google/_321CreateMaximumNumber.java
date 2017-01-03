package Google;

/**
 * Created by Shengwei_Wang on 11/9/16.
 */
public class _321CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); ++i) {
            int[] temp = merge(single(nums1, i), single(nums2, k - i));
            if (compareList(ans, 0, temp, 0) < 0)
                ans = temp;
        }
        return ans;
    } // maxNumber
    int[] single(int[] nums, int k) {
        int[] ans = new int[k];
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (j > 0 && nums.length - i + j > k && nums[i] > ans[j - 1])
                --j;
            if (j < k)
                ans[j++] = nums[i];
        }
        return ans;
    } //single
    int[] merge (int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < ans.length; ++k)
            if (compareList(nums1, i, nums2, j) < 0)
                ans[k] = nums2[j++];
            else
                ans[k] = nums1[i++];
        return ans;
    } //merge

    int compareList(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            ++i;
            ++j;
        }
        return (i == nums1.length?-1:nums1[i]) - (j == nums2.length?-1:nums2[j]);
    }

}
