/**
 * Created by Shengwei_Wang on 8/21/16.
 */
public class _338_CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        int pow = 1;
        for (int i = 1; i <= num; ++i) {
            if (pow + pow == i)
                pow = pow + pow;
            ans[i] = ans[i - pow] + 1;
        }
        return ans;
    }
}
