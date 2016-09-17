import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/12/16.
 */
public class _77_Combinations {
    List<List<Integer>> ans;
    int n;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        this.n = n;
        dfs(1, k, cur);
        return ans;
    }
    public void dfs(int start, int k, List<Integer> cur){
        if(k == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i <= n - k + 1; ++i){
            cur.add(i);
            dfs(i + 1, k - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
