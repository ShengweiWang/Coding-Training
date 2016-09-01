import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/31/16.
 */
public class _39_CombinationSum {
    List<List<Integer>> ans;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        dfs(0, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int index, int cur, List<Integer> ls){
        if(cur == target){
            ans.add(new ArrayList<Integer>(ls));
            return;
        } else if (cur > target || index >= candidates.length)
            return;
        for(int i = index; i < candidates.length; ++i){
            ls.add(candidates[i]);
            dfs(i, cur + candidates[i], ls);
            ls.remove(ls.size() - 1);
        }
    }
}
