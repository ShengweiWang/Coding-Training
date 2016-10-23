package Google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long l = lower;
        List<String> ans = new LinkedList<>();
        for(long cur : nums){
            if ( l + 1 == cur){
                ans.add(Long.toString(l));
            } else if ( l + 1 < cur) {
                ans.add(Long.toString(l) + "->" + Long.toString(cur - 1));
            }
            l = cur;
            ++l;
        }

        if (l == upper){
            ans.add(Long.toString(l));
        } else if (l < upper) {
            ans.add(Long.toString(l) + "->" + Integer.toString(upper));
        }
        return ans;
    }
}
