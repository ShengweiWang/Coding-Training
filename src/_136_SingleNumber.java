/**
 * Created by Shengwei_Wang on 8/21/16.
 */
public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            ans ^= nums[i];
        }
        return ans;
    }
}
