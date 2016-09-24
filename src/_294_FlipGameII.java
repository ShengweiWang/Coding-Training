import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _294_FlipGameII {
    Map<String, Boolean> map;
    char[] ss;
    public boolean canWin(String s) {
        map = new HashMap<>();
        ss = s.toCharArray();
        return canWin();
    }
    boolean canWin(){
        for(int i = 0; i < ss.length - 1; ++i)
            if(ss[i] == '+' && ss[i+1] == '+'){
                ss[i] = '-';
                ss[i+1] = '-';
                String news = new String(ss);
                if(!map.containsKey(news)){
                    map.put(news, canWin());
                }
                ss[i] = '+';
                ss[i+1] = '+';
                if(!map.get(news)) {
                    return true;
                }
            }
        return false;
    }
}
