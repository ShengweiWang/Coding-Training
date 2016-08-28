/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _377_CombinationSumIV {
    int[] f;
    boolean[] visited;
    public int combinationSum4(int[] nums, int target) {
        f = new int[target + 1];
        visited = new boolean[target + 1];
        f[0] = 1;
        visited[0] = true;
        return dfs(nums, target);

    }
    public int dfs(int[] nums, int target){
        if (target < 0)
            return 0;
        else if (visited[target])
            return f[target];
        for(int i = 0; i < nums.length; ++i)
            f[target] += dfs(nums, target - nums[i]);
        visited[target] = true;
        return f[target];
    }
}
