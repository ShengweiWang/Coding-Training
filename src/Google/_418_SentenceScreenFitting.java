package Google;

/**
 * Created by Shengwei_Wang on 10/20/16.
 */
public class _418_SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] count = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            count[i] =sentence[i].length();
            sum += count[i];
        }
        sum += n;
        int curr;
        int index = 0;
        int ans = 0;
        ans += (cols / sum);
        cols %= sum;
        if (cols == sum - 1) {
            ++ans;
            cols = 0;
        }
        ans *= rows;
        for (int i = 0; i < rows; ++i) {
            curr = cols;
            while (curr >= count[index]) {
                curr -= (count[index] + 1);
                if (++index == n) {
                    ++ans;
                    index = 0;
                }
            }
        }
        return ans;
    }
}
