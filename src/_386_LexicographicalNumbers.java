import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _386_LexicographicalNumbers {
    List<Integer> ans;
    int n;
    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<Integer>();
        this.n = n;
        if (n < 10) {
            for(int i = 1; i <= n; ++i){
                dfs(i);
            }
        } else{
            for(int i = 1; i < 10; ++i){
                dfs(i);
            }
        }
        return ans;
    }

    public void dfs(int cur){
        ans.add(cur);
        cur *= 10;
        for(int i = 0; i < 10; ++i){
            if (cur + i > n)
                return;
            else
                dfs(cur + i);
        }
    }
}
