/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _375_GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 2][n + 2];
        for(int i = 1; i < n; ++i)
            for(int j = 1; j + i <= n; ++j){
                int min = f[j + 1][j + i] + j;
                for(int k = j + 1; k <= j + i; ++k){
                    int temp = Math.max(f[j][k - 1], f[k + 1][j + i]) + k;
                    if(temp < min)
                        min = temp;
                }
                f[j][i + j] = min;
            }
        return f[1][n];
    }
}
