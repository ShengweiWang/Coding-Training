package Google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _340_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int count = 0;
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            int curCount = map.getOrDefault(c, 0);
            map.put(c, curCount + 1);
            if (curCount == 0) {
                ++count;
                if (count > k) {
                    while(map.get(s.charAt(start)) > 1){
                        map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                        ++start;
                    }
                    map.remove(s.charAt(start));
                    ++start;
                    --count;
                }
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
