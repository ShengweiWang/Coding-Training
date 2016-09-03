/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while(i < nums.length){
            if(nums[i] != val){
                nums[j] = nums[i];
                ++j;
            }
            ++i;
        }
        return j;
    }
}
