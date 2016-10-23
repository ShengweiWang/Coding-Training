package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapst = new HashMap<>();
        Map<Character, Character> mapts = new HashMap<>();
        if(s.length() != t.length())
            return false;
        for(int i = 0; i < s.length(); ++i){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(mapst.getOrDefault(cs,ct) != ct || mapts.getOrDefault(ct, cs) != cs)
                return false;
            mapst.put(cs,ct);
            mapts.put(ct,cs);
        }
        return true;
    }
}
