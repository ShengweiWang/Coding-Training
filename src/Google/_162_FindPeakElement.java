package Google;

/**
 * Created by Shengwei_Wang on 10/17/16.
 */
public class _162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1])
            return 0;
        int n = nums.length;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        int i = 1;
        int j = n - 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid - 1])
                j = mid - 1;
            else
                i = mid + 1;
        }
        return i;
    }
}
