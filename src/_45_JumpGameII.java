/**
 * Created by Shengwei_Wang on 9/22/16.
 */
public class _45_JumpGameII {
    public int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int cur = nums[0];
        int next = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length - 1; ++i){
            if(nums[i] + i > next){
                next = nums[i] + i;
            }
            if(i == cur) {
                cur = next;
                ++count;
            }
        }
        return count;
    }
}
