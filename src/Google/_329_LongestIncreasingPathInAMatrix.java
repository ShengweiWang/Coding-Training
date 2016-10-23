package Google;

import java.util.Arrays;

/**
 * Created by Shengwei_Wang on 10/18/16.
 */
public class _329_LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        if (n ==0)
            return 0;
        int m = matrix[0].length;
        if (m == 0)
            return 0;
        int nm = n * m;
        Integer[] index = new Integer[nm];
        for (int i = 0; i < index.length; ++i)
            index[i] = i;
        Arrays.sort(index, (a, b) -> (matrix[a / m][a % m] - matrix[b / m][b % m]));
        int[][] count = new int[n][m];
        int[][] dir = {{1, -1, 0, 0}, {0, 0, 1, -1}};
        int max = 0;
        for (int i = 0; i < nm; ++i) {
            int x = index[i] / m;
            int y = index[i] % m;
            max = Math.max(max, count[x][y]);
            for (int k = 0; k < 4; ++k) {
                int newx = x + dir[0][k];
                int newy = y + dir[1][k];
                if (newx >= 0 && newx < n && newy >= 0 && newy < m
                        && matrix[x][y] < matrix[newx][newy] && count[x][y] >= count[newx][newy])
                    count[newx][newy] = count[x][y] + 1;
            }

        }
        return max + 1;
    }
}
