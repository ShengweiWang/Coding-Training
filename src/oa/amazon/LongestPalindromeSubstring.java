package oa.amazon;

/**
 * Created by Shengwei_Wang on 12/17/16.
 */
public class LongestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        int[] save = {0, 0};
        for (int i = 0; i < s.length(); ++i) {
            expand(i - 1, i + 1, s, save);
            expand(i, i + 1, s, save);
        }
        return s.substring(save[0], save[1] + 1);
    }

    static void expand (int l, int r, String s, int[] save) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l > save[1] - save[0]) {
                save[0] = l;
                save[1] = r;
            }
            --l;
            ++r;
        }
    }
}
