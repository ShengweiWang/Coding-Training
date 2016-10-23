package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/19/16.
 */
public class _140_WordBreakII {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (map.containsKey(s))
            return map.get(s);
        List<String> ans = new LinkedList<>();
        if (s.length() == 0)
            ans.add("");
        for (int i = 1; i <= s.length(); ++i) {
            String sub = s.substring(0, i);
            if (wordDict.contains(sub)) {
                List<String> list = wordBreak(s.substring(i), wordDict);
                for (String news : list) {
                    if (news.length() == 0)
                        ans.add(sub);
                    else
                        ans.add(sub + " " + news);
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
}
