package Palindrome;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 11/9/16.
 */
public class _267_PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> cur = new HashMap<>();
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i ) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);


        } // for i
        boolean hasSingle = false;
        char single = 'c';
        for (char c : map.keySet()) {
            cur.put(c, 0);
            int get = map.get(c);
            if (get % 2 == 1) {
                if (hasSingle || s.length() % 2 == 0)
                    return ans;
                else {
                    hasSingle = true;
                    single = c;
                }
            }
            map.put(c, get / 2);
        } // for c
        permutation (map, cur, new StringBuilder(), s.length() / 2 , ans, hasSingle, single);
        return ans;
    } // generate
    void permutation (Map<Character, Integer> map, Map<Character, Integer> cur, StringBuilder sb, int len, List<String> ans, boolean hasSingle, char single) {
        if (sb.length() == len) {
            ans.add(sb.toString() + (hasSingle?single:"") + sb.reverse().toString());
            sb.reverse();
            return;
        } else {
            for (char c : map.keySet()) {
                int get = cur.get(c);
                if (get < map.get(c)) {
                    sb.append(c);
                    cur.put(c, get + 1);
                    permutation(map, cur, sb, len, ans, hasSingle, single);
                    sb.deleteCharAt(sb.length() - 1);
                    cur.put(c, get);
                }
            }
        }
    } // permutation

}
