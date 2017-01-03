/**
 * Created by Shengwei_Wang on 11/9/16.
 */
public class _5_LongestPalindromicSubstring { //char[] is extremely faster than s.charAt(i);
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        char[] ss = s.toCharArray();
        int startInd = 0;
        int max = 0;
        for (int i = 0; i < ss.length; ++i) {
            int l = i;
            int r = i;
            while (l >= 0 && r < ss.length && ss[l] == ss[r]) {
                --l;
                ++r;
            } // while
            if ( r - l - 1 > max) {
                max = r - l - 1;
                startInd = l + 1;
            }


            l = i - 1;
            r = i;
            while (l >= 0 && r < ss.length && ss[l] == ss[r]) {
                --l;
                ++r;
            } // while
            if ( r - l - 1 > max) {
                max = r - l - 1;
                startInd = l + 1;
            }
        }// for i
        return s.substring(startInd, startInd + max);
    } // longestPalindrome


}
