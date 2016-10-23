package Google;

/**
 * Created by Shengwei_Wang on 10/19/16.
 */
public class _318_MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] hash = new int[n];
        int i = 0;
        int j = 0;
        for (String s : words) {
            for (j = 0; j < s.length(); ++j) {
                hash[i] |= (1 << (s.charAt(j) - 'a'));

            }
            ++i;
        }
        int max = 0;
        for (i = 0; i < n; ++i)
            for (j = 0; j < n; ++j)
                if ((hash[i] & hash[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
        return max;
    }
}
