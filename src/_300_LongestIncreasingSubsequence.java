/**
 * Created by Shengwei_Wang on 9/7/16.
 */
public class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int llong = 1;
        int[] smallest = new int[nums.length + 1];
        smallest[0] = nums[0];
        smallest[1] = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; ++i){
            int l = 0;
            int r = llong;
            while(l < r){
                int mid = l + (r - l)/2;
                if(smallest[mid] >= nums[i])
                    r = mid;
                else
                    l = mid + 1;
            }
            smallest[l] = nums[i];
            if(l == llong){
                ++llong;
                smallest[llong] = Integer.MAX_VALUE;
            }
        }
        return llong;
    }
}
