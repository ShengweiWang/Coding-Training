/**
 * Created by Shengwei_Wang on 8/22/16.
 */
public class _283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i;
        int nextPos = 0;
        for (i = 0; i < nums.length; ++i){
            if(nums[i] != 0){
                if(nextPos != i)
                    nums[nextPos] = nums[i];
                ++nextPos;
            }
        }
        for (;nextPos < nums.length; ++nextPos)
            if (nums[nextPos] != 0)
                nums[nextPos] = 0;
    }
}
