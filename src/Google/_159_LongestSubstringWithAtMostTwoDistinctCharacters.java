package Google;

/**
 * Created by Shengwei_Wang on 10/20/16.
 */
public class _159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2)
            return s.length();
        int[] map = new int[256];
        char[] sa = s.toCharArray();
        final int t = 2;
        int count = 0;
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < sa.length; ++i) {
            if (++map[sa[i]] == 1) {
                ++count;
            }
            if (count > t) {
                while (--map[sa[start++]] != 0);
                --count;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }
}
