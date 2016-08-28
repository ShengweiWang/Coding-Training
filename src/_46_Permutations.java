import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(nums, 0, res);
        return res;
    }

    public void dfs(int[] nums, int begin, List<List<Integer>> res){
        if (begin == nums.length){
            List<Integer> cur = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; ++i)
                cur.add(nums[i]);
            res.add(cur);
            return;
        }
        for(int i = begin; i < nums.length; ++i){
            int temp = nums[i];
            nums[i] = nums[begin];
            nums[begin] = temp;
            dfs(nums, begin + 1, res);
            temp = nums[i];
            nums[i] = nums[begin];
            nums[begin] = temp;
        }
    }
}
