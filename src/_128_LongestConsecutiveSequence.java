import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; ++i){
            if(set.contains(nums[i]))
                continue;
            else
                set.add(nums[i]);
            int left = 0;
            int right = 0;
            if(hashmap.containsKey(nums[i] - 1)){
                left = hashmap.get(nums[i] - 1);
            }
            if(hashmap.containsKey(nums[i] + 1)){
                right = hashmap.get(nums[i] + 1);
            }
            int sum = right + left + 1;
            if(sum > max)
                max = sum;
            hashmap.put(nums[i] - left, sum);
            hashmap.put(nums[i] + right, sum);
        }
        return max;
    }
}
