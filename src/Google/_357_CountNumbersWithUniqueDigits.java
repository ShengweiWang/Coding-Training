package Google;

/**
 * Created by Shengwei_Wang on 10/23/16.
 */
public class _357_CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int[] f = new int[11];
        f[1] = 9;
        int seed = 9;
        int ans = 10;
        for(int i = 2; i < 11 && i <= n; ++i){
            f[i] = f[i-1] * seed;
            --seed;
            ans += f[i];
        }
        return ans;
    }
}
