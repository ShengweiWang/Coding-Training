/**
 * Created by Shengwei_Wang on 9/6/16.
 */
public class _279_PerfectSquares {
    int min;
    public int numSquares(int n) {
        min = Integer.MAX_VALUE;
        int k = (int)Math.sqrt(n);
        dfs(n, k, 0);
        return min;
    }
    public void dfs(int n, int k, int cur){
        if(n == 0) {
            if (cur < min)
                min = cur;
        }
        if(cur < min) {
            for(int i = k; i > 0; --i){
                dfs(n - i * i, Math.min((int)Math.sqrt(n - i * i), i), cur + 1);
            }
        }
    }
}
