/**
 * Created by Shengwei_Wang on 9/6/16.
 */
public class _376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int j = 1;
        while(j < nums.length && nums[j] == nums[j - 1])
            ++j;
        if(j == nums.length)
            return 1;
        int lastsig;
        if(nums[j] - nums[j - 1] > 0)
            lastsig = 1;
        else
            lastsig = -1;

        int count = 2;
        ++j;
        while(j < nums.length) {
            if(nums[j] > nums[j - 1] && lastsig == -1){
                ++count;
                lastsig = 1;
            } else if(nums[j] < nums[j - 1] && lastsig == 1){
                ++count;
                lastsig = -1;
            }
            ++j;
        }
        return count;
    }
}
