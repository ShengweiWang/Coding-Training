import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/7/16.
 */
public class _247_StrobogrammaticNumberII {
    List<String> ans;
    public List<String> findStrobogrammatic(int n) {
        ans = new ArrayList<String>();
        if(n == 0){
            return ans;
        } else if(n == 1){
            ans.add("0");
            ans.add("1");
            ans.add("8");
            return ans;
        } else {
            dfs("6", "9", n - 2);
            dfs("9", "6", n - 2);
            dfs("8", "8", n - 2);
            dfs("1", "1", n - 2);
        }
        return ans;
    }

    public void dfs(String l, String r, int n){
        if(n == 0){
            ans.add(l + r);
        } else if(n == 1){
            ans.add(l + "0" + r);
            ans.add(l + "1" + r);
            ans.add(l + "8" + r);
        } else {
            dfs(l + "6", "9" + r, n - 2);
            dfs(l + "9", "6" + r, n - 2);
            dfs(l + "0", "0" + r, n - 2);
            dfs(l + "8", "8" + r, n - 2);
            dfs(l + "1", "1" + r, n - 2);
        }
    }
}
