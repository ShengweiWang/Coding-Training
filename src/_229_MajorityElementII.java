import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int first = 0;
        int count1 = 0;
        int second = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; ++i){
            if (first == nums[i]){
                ++count1;
            } else if (second == nums[i]){
                ++count2;
            } else if(count1 == 0){
                ++count1;
                first = nums[i];
            } else if (count2 == 0) {
                ++count2;
                second = nums[i];
            }  else {
                --count1;
                --count2;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; ++i)
            if(first == nums[i])
                ++count1;
            else if (second == nums[i])
                ++count2;
        if(count1 > nums.length/3)
            ans.add(first);
        if(count2 > nums.length/3)
            ans.add(second);
        return ans;
    }
}
