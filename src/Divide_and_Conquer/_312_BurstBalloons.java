package Divide_and_Conquer;

/**
 * Created by Shengwei_Wang on 10/13/16.
 */
public class _312_BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        n += 2;
        int[] a = new int[n];
        a[0] = 1;
        a[n - 1] = 1;
        for(int i = 0; i < nums.length; ++i)
            a[i + 1] = nums[i];
        int[][] f = new int[n][n];

        for(int k = 2; k < n; ++k){
            for(int i = 0; i < n - k; ++i){
                int j = i + k;
                for(int m = i + 1; m < j; ++m)
                    f[i][j] = Math.max(f[i][j], f[i][m] + f[m][j] + a[i] * a[m] * a[j]);
            }
        }
        return f[0][n - 1];
    }
}
