package Google;

/**
 * Created by Shengwei_Wang on 10/25/16.
 */
public class _409_LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] f = new int[512];
        for (int i = 0; i < s.length(); ++i)
            ++f[s.charAt(i)];
        int count = 0;
        int extra = 0;
        for (int i = 0; i < 512; ++i) {
            count += ((f[i] >> 1) << 1);
            extra |= (f[i] & 1);
        }
        return count + extra;
    }
}
