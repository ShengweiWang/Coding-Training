package Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _200_NumberOfIsland {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean [n][m];
        for(int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j){
                if(grid[i][j] == '1' && !visited[i][j]) {
                    ++count;
                    bfs_queue(i, j, visited, grid, n, m);
                }

            }
        return count;
    }

    void dfs_stack(int startx, int starty, boolean[][] visited, char[][] grid, int n, int m){
        Deque<Integer> stackx = new ArrayDeque<>();
        Deque<Integer> stacky = new ArrayDeque<>();
        stackx.push(startx);
        stacky.push(starty);
        visited[startx][starty] = true;
        int[] xi = {1, -1, 0, 0};
        int[] yi = {0, 0, 1, -1};
        while(stackx.size() > 0){
            int x = stackx.pop();
            int y = stacky.pop();
            for(int i = 0; i < 4; ++i){
                int newx = x + xi[i];
                int newy = y + yi[i];
                if(newx >= 0 && newx < n && newy >= 0 && newy < m && !visited[newx][newy] && grid[newx][newy] == '1') {
                    visited[newx][newy] = true;
                    stackx.push(newx);
                    stacky.push(newy);
                }

            }
        }
    }

    void bfs_queue(int startx, int starty, boolean[][] visited, char[][] grid, int n, int m) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(startx);
        qy.offer(starty);
        visited[startx][starty] = true;
        int[] xi = {1, -1, 0, 0};
        int[] yi = {0, 0, 1, -1};
        while(qx.size() > 0){
            int x = qx.poll();
            int y = qy.poll();
            for(int i = 0; i < 4; ++i){
                int newx = x + xi[i];
                int newy = y + yi[i];
                if(newx >= 0 && newx < n && newy >= 0 && newy < m && !visited[newx][newy] && grid[newx][newy] == '1') {
                    visited[newx][newy] = true;
                    qx.offer(newx);
                    qy.offer(newy);
                }

            }
        }
    }
}
