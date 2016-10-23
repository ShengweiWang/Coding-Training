package Google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 10/18/16.
 */
public class _317_ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        if (n == 0)
            return -1;
        int m = grid[0].length;
        if (m == 0)
            return -1;
        int[][] count = new int[n][m];
        int[][] distance = new int[n][m];
        int totalBuildings = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ++totalBuildings;
                    bfs (i, j, grid, distance, count, n, m);
                }
            }
        int ans = -1;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (count[i][j] == totalBuildings) {
                    if (ans == -1 || distance[i][j] < ans)
                        ans = distance[i][j];
                }
            }
        return ans;
    }

    public static void main (String[] argvs) {
        _317_ShortestDistanceFromAllBuildings solution = new _317_ShortestDistanceFromAllBuildings();
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(solution.shortestDistance(grid));
    }

    void bfs (int i, int j, int[][] grid, int[][] distance, int[][] count, int n, int m) {
        int[][] dir = {{1, -1, 0, 0}, {0 ,0 ,1, -1}};
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();
        qx.offer(i);
        qy.offer(j);
        qd.offer(1);
        while (qx.size() > 0) {
            int currx = qx.poll();
            int curry = qy.poll();
            int currd = qd.poll();
            for (int k = 0; k < 4; ++k) {
                int x = currx + dir[0][k];
                int y = curry + dir[1][k];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && grid[x][y] == 0) {
                    visited[x][y] = true;
                    ++count[x][y];
                    distance[x][y] += currd;
                    qx.offer(x);
                    qy.offer(y);
                    qd.offer(currd + 1);
                }
            }
        }
    }
}
