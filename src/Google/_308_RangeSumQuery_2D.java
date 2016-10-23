package Google;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _308_RangeSumQuery_2D {
    int[][] tree;
    int[][] matrix;
    int n;
    int m;
    public _308_RangeSumQuery_2D (int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        n = matrix.length;
        m = matrix[0].length;
        this.matrix = new int[n][m];
        tree = new int[n + 1][m + 1];
        for(int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                update(i, j, matrix[i][j]);
            }
    }
    public void update(int x, int y, int val) {
        if (n == 0 || m == 0)
            return;
        int delta = val - matrix[x][y];
        matrix[x][y] = val;
        for(int i = x + 1; i <= n; i += (i & -i))
            for (int j = y + 1; j <= m; j += (j & -j)){
                tree[i][j] += delta;
            }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row1, col1) + sum(row2+1, col2+1) - sum(row1, col2+1) - sum(row2 + 1, col1);
    }

    public int sum (int x, int y) {
        int ans = 0;
        for(int i = x; i > 0; i -= (i & -i))
            for(int j = y; j > 0; j -= (j & -j))
                ans += tree[i][j];
        return ans;
    }
}
