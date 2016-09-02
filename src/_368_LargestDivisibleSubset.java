import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _368_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0)
            return new ArrayList<>();
        int maxIndex = 0;
        int maxSize = 0;
        int[] f = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i){
            f[i] = 0;
            prev[i] = i;
            for(int j = 0; j < i; ++j){
                if(nums[i] % nums[j] == 0 && f[j] > f[i]){
                    f[i] = f[j];
                    prev[i] = j;
                }
            }
            ++f[i];
            if(f[i] > maxSize){
                maxSize = f[i];
                maxIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(prev[maxIndex] != maxIndex){
            ans.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        ans.add(nums[maxIndex]);
        return ans;
    }
}
