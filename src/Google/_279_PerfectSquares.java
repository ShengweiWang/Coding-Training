package Google;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _279_PerfectSquares {
    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        for( int i = 1; i <= n; ++i){
            ans[i] = Integer.MAX_VALUE;
            for(int j = (int)Math.sqrt(i); j > 0; --j){
                ans[i] = Math.min(ans[i], ans[i - j * j] + 1);
            }
        }
        return ans[n];
    }
}
