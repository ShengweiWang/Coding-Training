import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _325_MaximunSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        int[] f = new int[nums.length];
        Map<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0, -1);
        int ans = 0;
        for(int i = 0; i < nums.length; ++i){
            try{
                f[i] += (f[i-1] + nums[i]);
            } catch(Exception e) {
                f[i] = nums[i];
            }

            if(hashmap.getOrDefault(f[i], i) == i){
                hashmap.put(f[i],i);
            }
            int cur = i - (hashmap.getOrDefault(f[i] - k, i));
            if(cur > ans)
                ans = cur;
        }
        return ans;
    }
}
