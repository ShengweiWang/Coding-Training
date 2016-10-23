package Google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        if(nums.length == 0)
            return ans;
        int start = nums[0];
        int last = nums[0];
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] - last == 1){
                ++last;
            } else {
                if(start == last)
                    ans.add(Integer.toString(start));
                else
                    ans.add(Integer.toString(start) + "->" + Integer.toString(last));
                start = nums[i];
                last = start;
            }
        }
        if(start == last)
            ans.add(Integer.toString(start));
        else
            ans.add(Integer.toString(start) + "->" + Integer.toString(last));
        return ans;
    }
}
