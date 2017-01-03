package Google;

/**
 * Created by Shengwei_Wang on 10/25/16.
 */
public class _330_PatchingArray {
    public int minPatches(int[] nums, int n) {
        long curr = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (curr + 1 < nums[i] && curr < n) {
                curr += (curr + 1);
                ++count;
            }
            if (curr >= n)
                return count;
            curr += nums[i];
        }
        while (curr < n) {
            curr += (curr + 1);
            ++count;
        }
        return count;
    }
}
