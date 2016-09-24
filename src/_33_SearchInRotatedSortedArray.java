/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)
            return -1;
        if(target == nums[0]) {
            return 0;
        } else if (target < nums[0]){
            int l = 0;
            int r = n - 1;
            while(l < r){
                int mid = l + (r - l)/2;
                if(nums[mid] == target)
                    return mid;
                else if(nums[n - 1] < nums[mid] || nums[mid] < target)
                    l = mid + 1;
                else
                    r = mid;
            }
            if(nums[l] == target)
                return l;
        } else {
            int l = 0;
            int r = n - 1;
            while(l < r){
                int mid = l + (r - l)/2;
                if(nums[mid] == target)
                    return mid;
                else if (nums[mid] < nums[0])
                    r = mid - 1;
                else if (nums[mid] < target)
                    l = mid + 1;
                else
                    r = mid;
            }
            if(nums[l] == target)
                return l;
        }
        return -1;
    }
}
