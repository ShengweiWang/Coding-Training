/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _268_MissingNumber {
    public int missingNumber(int[] nums) {
        long cur = 0;
        for(int i = 0; i < nums.length; ++i){
            cur += nums[i];
        }
        return (int)((long)nums.length * (nums.length + 1)/2 - cur);
    }
}
