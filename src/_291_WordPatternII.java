import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _291_WordPatternII {
    HashMap<Character, String> hashMap;
    Set<String> set;
    String pattern;
    public boolean wordPatternMatch(String pattern, String str) {
        hashMap = new HashMap<>();
        set = new HashSet<>();
        this.pattern = pattern;
        return find(0, str);
    }
    boolean find (int k, String str) {
        if (k == pattern.length() && str.length() == 0) {
            return true;
        } else if (k == pattern.length() || str.length() == 0){
            return false;
        }
        char p = pattern.charAt(k);
        if(hashMap.containsKey(p)){
            if(str.startsWith(hashMap.get(p)) && find(k + 1, str.substring(hashMap.get(p).length())))
                return true;
            else
                return false;
        }
        for(int i = 1; i <= str.length(); ++i){
            String sub = str.substring(0, i);
            if(set.contains(sub))
                continue;
            hashMap.put(p, sub);
            set.add(sub);
            if(find(k+1, str.substring(i)))
                return true;
            set.remove(sub);
            hashMap.remove(p);
        }
        return false;
    }
}
