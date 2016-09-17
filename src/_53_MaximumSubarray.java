/**
 * Created by Shengwei_Wang on 9/13/16.
 */
public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int sum = nums[0];
        int max = sum;
        for(int i = 1; i < nums.length; ++i){
            if(sum < 0){
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if(sum > max)
                max = sum;
        }
        return max;
    }
}
