/**
 * Created by Shengwei_Wang on 9/12/16.
 */
public class _334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;
        int min1 = nums[0];
        int min2 = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > min2){
                return true;
            } else if (nums[i] > min1){
                min2 = nums[i];
            } else {
                min1 = nums[i];
            }
        }
        return false;
    }
}
