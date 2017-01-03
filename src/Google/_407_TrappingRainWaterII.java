package Google;

import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 11/3/16.
 */
public class _407_TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[] visited = new boolean[n * m];
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(heightMap[a / m][a % m] - heightMap[b / m][b % m]));
        for (int i = 0; i < n; ++i) {
            q.offer(i * m);
            q.offer((i + 1) * m - 1);
            visited[i * m] = true;
            visited[(i + 1) * m - 1] = true;
        }
        for (int j = 1; j < m - 1; ++j) {
            q.offer(j);
            q.offer((n - 1) * m + j);
            visited[j] = true;
            visited[(n - 1) * m + j] = true;
        }
        int res = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (q.size() > 0) {
            int curr = q.poll();
            int h = heightMap[curr / m][curr % m];
            for (int i = 0; i < 4; ++i) {
                int x = curr / m + dirs[i][0];
                int y = curr % m + dirs[i][1];
                if (x < n && x >= 0 && y < m && y >= 0 && !visited[x * m + y]) {
                    res += Math.max(0, h - heightMap[x][y]);
                    heightMap[x][y] = Math.max(heightMap[x][y], h);
                    visited[x * m + y] = true;
                    q.offer(x * m + y);
                }
            }
        }
        return res;
    }
}
