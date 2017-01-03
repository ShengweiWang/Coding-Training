package oa.amazon;

/**
 * Created by Shengwei_Wang on 12/29/16.
 */
public class RotateMatrix {
    public static int[][] rotate (int[][] matrix, int flag) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                ans[j][i] = matrix[i][j];
            }
        return ans;
    }
}
