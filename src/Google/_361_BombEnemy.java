package Google;

/**
 * Created by Shengwei_Wang on 10/17/16.
 */
public class _361_BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        if (m == 0)
            return 0;

        int[][] f = new int[n][m];
        for (int i = 0; i < n; ++i) {
            int start = 0;
            int count = 0;
            for (int j = 0; j <= m; ++j) {
                if (j == m || grid[i][j] == 'W') {
                    while (start < j) {
                        if (grid[i][start] == '0')
                            f[i][start] += count;
                        ++start;
                    }
                    count = 0;
                }
                else if (grid[i][j] == 'E')
                    ++count;
            }
        }
        int max = 0;
        for (int j = 0; j < m; ++j) {
            int start = 0;
            int count = 0;
            for (int i = 0; i <= n; ++i) {
                if (i == n || grid[i][j] == 'W') {
                    while (start < i) {
                        if (grid[start][j] == '0') {
                            f[start][j] += count;
                            max = Math.max(max, f[start][j]);
                        }
                        ++start;
                    }
                    count = 0;
                }
                else if (grid[i][j] == 'E')
                    ++count;
            }
        }
        return max;
    }
}
