/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int max = nums[0];
        int seed = 1;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                if(max < 0)
                    max = 0;
                seed = 1;
                continue;
            }
            seed *= nums[i];
            if(seed > max)
                max = seed;
        }
        seed = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            if(nums[i] == 0){
                seed = 1;
                continue;
            }
            seed *= nums[i];
            if(seed > max)
                max = seed;
        }
        return max;
    }
}
