import java.util.Arrays;

/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _259_3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2;++i){
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] < target){
                    count += (r - l);
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return count;
    }
}
