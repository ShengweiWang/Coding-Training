import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<String>();
        int start = lower;
        for(int i = 0; i < nums.length; ++i){
            if(start < nums[i]){
                int end = nums[i] - 1;
                if(start == end){
                    ans.add(Integer.toString(start));
                } else {
                    ans.add(Integer.toString(start) + "->" + Integer.toString(end));
                }
            }
            start = nums[i] + 1;
        }
        int end = upper;
        if(start == end){
            ans.add(Integer.toString(start));
        } else if (start < end) {
            ans.add(Integer.toString(start) + "->" + Integer.toString(end));
        }
        return ans;
    }
}
