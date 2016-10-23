package Google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/21/16.
 */
public class _417_PacificAtlanticWaterFlow {
    int[][] dir;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new LinkedList<>();
        dir = new int[][] {{1, -1, 0, 0}, {0, 0, 1, -1}};
        int n = matrix.length;
        if (n == 0)
            return list;
        int m = matrix[0].length;
        if (m == 0)
            return list;
        boolean[][] mark_pacific = new boolean[n][m];
        boolean[][] mark_atlantic = new boolean[n][m];
        for (int i = 0; i < n; ++i){
            if (!mark_pacific[i][0]) {
                mark_pacific[i][0] = true;
                dfs(i, 0, mark_pacific, matrix);
            }
            if (!mark_atlantic[i][m - 1]) {
                mark_atlantic[i][m - 1] = true;
                dfs(i, m -1, mark_atlantic, matrix);
            }
        }

        for (int j = 0; j < m; ++j){
            if (!mark_pacific[0][j]) {
                mark_pacific[0][j] = true;
                dfs(0, j, mark_pacific, matrix);
            }
            if (!mark_atlantic[n - 1][j]) {
                mark_atlantic[n - 1][j] = true;
                dfs(n - 1, j, mark_atlantic, matrix);
            }
        }
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (mark_pacific[i][j] && mark_atlantic[i][j])
                    list.add(new int[]{i, j});
        return list;


    }

    void dfs(int x, int y, boolean[][] mark, int[][]matrix) {
        for (int k = 0; k < 4; ++k) {
            int newx = x + dir[0][k];
            int newy = y + dir[1][k];
            if (newx >= 0 && newx < matrix.length && newy >= 0 && newy < matrix[0].length
                    && matrix[x][y] <= matrix[newx][newy] && !mark[newx][newy]) {
                mark[newx][newy] = true;
                dfs(newx, newy, mark, matrix);
            }
        }
    }
}
