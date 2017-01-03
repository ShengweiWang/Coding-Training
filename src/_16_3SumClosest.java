import java.util.Arrays;

/**
 * Created by Shengwei_Wang on 11/7/16.
 */
public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; ++i) {
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (Math.abs(temp - target) < Math.abs(res - target))
                    res = temp;
                if (temp == target)
                    return target;
                else if (temp > target)
                    --r;
                else
                    ++l;
            }
        }
        return res;
    }
}
