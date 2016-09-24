/**
 * Created by Shengwei_Wang on 9/23/16.
 */
public class _308_RangeSumQuery2D_Mutable {
    int[][] matrix;
    int[][] tree;
    int n;
    int m;
    public _308_RangeSumQuery2D_Mutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        n = matrix.length;
        m = matrix[0].length;
        tree = new int[n+1][m+1];
        this.matrix = new int[n][m];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                update(i, j, matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        for(int i = row + 1; i <= n; i += (i & -i))
            for(int j = col + 1; j <= m; j += (j & -j))
                tree[i][j] += delta;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row1, col1) + sum(row2+1, col2+1) - sum(row1, col2+1) - sum(row2 + 1, col1);
    }

    int sum (int row, int col){
        int ans = 0;
        for(int i = row; i > 0; i -= (i & -i))
            for(int j = col; j > 0; j -= (j & -j))
                ans += tree[i][j];
        return ans;

    }
}
