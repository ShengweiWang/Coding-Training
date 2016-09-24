import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _317_ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        if(n == 0)
            return 0;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        int[][] reach = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j){
                if(grid[i][j] == 1){
                    bfs(i, j, distance, grid, n, m, reach);
                    ++count;
                }
            }
        int min = -1;
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j)
                if(grid[i][j] == 0 && reach[i][j] == count && (distance[i][j] < min || min == -1))
                    min = distance[i][j];
        return min;
    }
    void bfs(int i, int j, int[][] distance, int[][] grid, int n, int m, int[][] reach){
        boolean[][] visited = new boolean[n][m];
        int[][] cur = new int[n][m];
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        visited[i][j] = true;
        qx.offer(i);
        qy.offer(j);
        while(qx.size() > 0){
            int x = qx.poll();
            int y = qy.poll();
            distance[x][y] += cur[x][y];
            ++reach[x][y];
            for(int k = 0; k < 4; ++k){
                int xi = x + dir[k][0];
                int yi = y + dir[k][1];
                if(xi >=0 && xi < n && yi >=0 && yi < m && grid[xi][yi] == 0 && !visited[xi][yi]){
                    cur[xi][yi] = cur[x][y] + 1;
                    visited[xi][yi] = true;
                    qx.offer(xi);
                    qy.offer(yi);
                }

            }
        }
    }
}
