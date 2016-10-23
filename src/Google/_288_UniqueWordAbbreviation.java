package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _288_UniqueWordAbbreviation { //corner: dictionary duplicate
    Map<String, Integer> map;
    Set<String> set;
    String parse(String s){
        StringBuilder sb = new StringBuilder();
        if (s.length() < 3)
            return s;
        else {
            sb.append(s.charAt(0));
            sb.append(s.length() - 2);
            sb.append(s.charAt(s.length() - 1));
            return sb.toString();
        }
    }

    public _288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        set = new HashSet<>();
        for(String orig : dictionary){
            if (set.contains(orig))
                continue;
            set.add(orig);
            String abv = parse(orig);
            map.put(abv, map.getOrDefault(abv, -1) + 1);
        }
    }

    public boolean isUnique(String word) {
        String abv = parse(word);
        int k = map.getOrDefault(abv, -1);
        if (k > 0 || (k == 0 && !set.contains(word)))
            return false;
        else
            return true;
    }
}
