package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/28/16.
 */
public class _290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<String, String> map = new HashMap<String, String>();
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length)
            return false;
        for(int i = 0; i < pattern.length() ; ++i){
            String s1 = pattern.substring(i, i+1);
            String s2 = strs[i];
            if(map.getOrDefault("(rev)" +s1, s2).compareTo(s2) != 0 || map.getOrDefault(s2, s1).compareTo(s1) != 0)
                return false;
            else {
                map.put("(rev)" +s1, s2);
                map.put(s2,s1);
            }
        }
        return true;
    }
}
