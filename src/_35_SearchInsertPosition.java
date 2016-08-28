/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        if(nums[l] < target)
            return l + 1;
        else
            return l;
    }

}
