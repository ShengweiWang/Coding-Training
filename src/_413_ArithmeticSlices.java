/**
 * Created by Shengwei_Wang on 11/5/16.
 */
public class _413_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;
        int ans = 0;
        int i = 2;
        while (i < A.length) {
            int k = i - 2;
            while (i < A.length && A[i] - A[i - 1] == A[i - 1] - A[i - 2])
                ++i;
            if (i - k > 2) {
                ans += (1 + i - k - 2) * (i - k - 2) / 2;
            }
            ++i;
        }
        return ans;
    }
}
