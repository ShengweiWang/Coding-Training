/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return 1;
        int j = nums.length - 1;
        while(j > 0 && nums[j] == nums[0])
            --j;
        if(nums[j] > nums[0])
            return nums[0];

        if(j == 0)
            return nums[0];
        int i = 0;
        while(i < j){
            int mid = i + (j - i)/2;
            if(nums[mid] >= nums[0])
                i = mid + 1;
            else
                j = mid;
        }
        return nums[i];
    }
}
