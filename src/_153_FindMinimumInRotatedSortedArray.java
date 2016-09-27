/**
 * Created by Shengwei_Wang on 9/25/16.
 */
public class _153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int m = nums.length;
        if(nums.length == 0)
            return 0;
        if(nums[0] <= nums[m - 1]){
            return nums[0];
        }
        int l = 0;
        int r = m - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= nums[0])
                l = mid + 1;
            else
                r = mid;
        }
        return nums[l];
    }
}
