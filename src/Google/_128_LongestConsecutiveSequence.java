package Google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 10/17/16.
 */
public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, num);
        for (int num : nums) {
            if (!map.containsKey(num))
                continue;
            int l = map.get(num);
            while (map.containsKey(l + 1)) {
                int next = map.get(l + 1);
                map.remove(l + 1);
                l = next;
            }
            map.put(num, l);
            max = Math.max(max, l - num + 1);
        }
        return max;
    }
}
