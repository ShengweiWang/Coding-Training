package oa.amazon.important9;

/**
 * Created by Shengwei_Wang on 1/1/17.
 */
public class LongestP {
    public static String longestPalindrome (String s) {
        if (s == null || s.length() <= 1)
            return s;
        int[] save = {0, 0};
        for (int i = 0; i < s.length(); ++i) {
            expand(s, i, i, save);
            expand(s, i - 1, i, save);
        }
        return s.substring(save[0], save[1]);
    }

    static void expand(String s, int left, int right, int[] save) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        ++left;
        --right;
        if (save[1] - save[0] < (right - left)) {
            save[0] = left;
            save[1] = right;
        }
    }

}
