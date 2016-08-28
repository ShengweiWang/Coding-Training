import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _22_GenerateParentheses {
    HashMap<Integer, List<String>> map;
    public List<String> generateParenthesis(int n) {
        map = new HashMap<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.add("");
        map.put(0, temp);
        return dfs(n);
    }
    public List<String> dfs(int n){
        if(map.containsKey(n))
            return map.get(n);
        ArrayList<String> ans = new ArrayList<String>();
        for(int i = 0; i < n; ++i){
            List<String> tempin = dfs(i);
            List<String> tempout = dfs(n - i - 1);
            for(String s1 : tempin)
                for (String s2 : tempout){
                    ans.add("(" + s1 + ")" + s2);
                }
        }
        map.put(n, ans);
        return ans;
    }
}
