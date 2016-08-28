import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _216_CombinationSumIII {
    List<List<Integer>> finalList;
    public List<List<Integer>> combinationSum3(int k, int n) {
        finalList = new ArrayList<>();
        dfs(k, n, 0, 1);
        return finalList;
    }
    public void dfs(int k, int n, int ans, int next){
//        System.out.println(next);
        if (k == 0 && n == 0 && next == 10){
            System.out.println(next);
            List<Integer> tempList = new ArrayList<>();
            ans >>= 1;
            int now = 1;
            while(ans > 0){
                if((ans & 1) == 1)
                    tempList.add(now);
                ans >>= 1;
                ++now;
            }
            finalList.add(tempList);
            return;
        }
        if ( k < 0 || next + k > 10 || n < 0)
            return;

        for(int i = next; i < 10; ++i){
            dfs(k, n, ans, i + 1);
            dfs(k-1, n - i, ans |(1 << i), i+1);
        }
    }
}
