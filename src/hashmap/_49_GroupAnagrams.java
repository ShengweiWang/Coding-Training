package hashmap;

import java.util.*;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new LinkedList<>();
        for(int i = 0; i < strs.length; ++i){
            char[] cur = strs[i].toCharArray();
            Arrays.sort(cur);
            String mapped = new String(cur);
            if(!map.containsKey(mapped)){
                List<String> group = new LinkedList<>();
                map.put(mapped, group);
                ans.add(group);
            }
            map.get(mapped).add(strs[i]);
        }
        return ans;
    }
}
