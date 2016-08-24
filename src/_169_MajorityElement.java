/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int cur = nums[0];
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == cur)
                ++count;
            else{
                if(--count < 0){
                    cur = nums[i];
                    count = 0;
                }
            }
        }
        return cur;
    }
}
