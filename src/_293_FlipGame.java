import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _293_FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<String>();
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i) == '+' && s.charAt(i) == s.charAt(i-1)){
                ans.add(s.substring(0, i - 1) + "--" + s.substring(i+1));
            }
        }
        return ans;
    }
}
