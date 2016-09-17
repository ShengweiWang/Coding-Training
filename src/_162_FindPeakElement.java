/**
 * Created by Shengwei_Wang on 9/7/16.
 */
public class _162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1])
            return 0;
        for(int i = 1; i < nums.length - 1; ++i)
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
        return nums.length - 1;
    }
}
