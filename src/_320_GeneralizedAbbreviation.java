import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _320_GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        dfs(res, word, 0, "", 0);
        return res;
    }
    public void dfs(List<String> res, String word, int pos, String cur, int count){
        if(pos == word.length()){
            if(count > 0){
                cur += count;
            }
            res.add(cur);
        } else{
            dfs(res, word, pos + 1, cur, count + 1);
            if(count > 0){
                dfs(res, word, pos + 1, cur + count + word.charAt(pos), 0);
            } else {
                dfs(res, word, pos + 1, cur + word.charAt(pos), 0);
            }
        }
    }
}
