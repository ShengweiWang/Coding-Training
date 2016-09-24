/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _330_PatchingArray {
    public int minPatches(int[] nums, int n) {
        long reached = 1;
        int index = 0;
        int need = 0;
        int start = 1;
        if(nums.length == 0 || nums[0] != 1){
            ++need;
            start = 0;
        }
        for(int i = start; i < nums.length; ++i){
            while(reached < nums[i] - 1 && reached < n){
                reached += reached;
                ++reached;
                ++need;
            }
            reached += (long)nums[i];
            if(reached >= n)
                break;
        }
        while(reached < n){
            reached += reached;
            ++reached;
            ++need;
        }
        return need;
    }
}
