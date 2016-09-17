/**
 * Created by Shengwei_Wang on 9/12/16.
 */
public class _59_SpiralMatrixII {
    int[][] ans;
    public int[][] generateMatrix(int n) {
        ans = new int[n][n];
        int x = 0;
        int count = 1;
        for(int k = n; k > 1; k = k - 2){
            int i = x;
            int j = x;
            for(int c = 1; c < k; ++c){
                ans[i][j] = count;
                ++count;
                ++j;
            }
            for(int c = 1; c < k; ++c){
                ans[i][j] = count;
                ++count;
                ++i;
            }
            for(int c = 1; c < k; ++c){
                ans[i][j] = count;
                ++count;
                --j;
            }
            for(int c = 1; c < k; ++c){
                ans[i][j] = count;
                ++count;
                --i;
            }
            ++x;
        }
        if(n%2 == 1){
            ans[x][x] = count;
        }
        return ans;
    }
}
