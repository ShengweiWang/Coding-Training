/**
 * Created by Shengwei_Wang on 8/31/16.
 */
public class _80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        while(right < nums.length){
            int temp = right;
            while(right < nums.length && nums[right] == nums[temp]){
                ++right;
            }
            nums[left] = nums[temp];
            ++left;
            if(right - temp > 1){
                nums[left] = nums[temp];
                ++left;
            }
        }
        return left;
    }
}
