import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; ++i){
                set.add(nums[i]);
        }
        if(set.size() < nums.length)
            return false;
        return true;
    }
}
