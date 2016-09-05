/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int l = 0;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] != nums[i-1]){
                ++l;
                nums[l] = nums[i];
            }
        }
        return l + 1;
    }
}
