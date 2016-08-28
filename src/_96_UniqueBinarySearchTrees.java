/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _96_UniqueBinarySearchTrees {
    public int numTrees(int n){
        int[] f = new int[n + 1];
        f[0] = 1;
        for(int i = 1; i <= n ; ++i){
            for(int j = 1; j <= i; ++j){
                f[i] += f[i - j] * f[j - 1];
            }
        }
        return f[n];
    }
}
