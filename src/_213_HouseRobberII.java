/**
 * Created by Shengwei_Wang on 8/31/16.
 */
public class _213_HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int take = nums[0];
        int nottake = 0;
        for(int i = 1; i < nums.length - 1; ++i){
            int temp = take;
            take = Math.max(nottake + nums[i], take);
            nottake = Math.max(nottake, temp);
        }
        int ans = Math.max(take, nottake);
        take = nums[1];
        nottake = 0;
        for(int i = 2; i < nums.length; ++i){
            int temp = take;
            take = Math.max(nottake + nums[i], take);
            nottake = Math.max(nottake, temp);
        }
        ans = Math.max(ans, Math.max(take,nottake));
        return ans;
    }
}
