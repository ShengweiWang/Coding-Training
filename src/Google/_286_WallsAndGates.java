package Google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 10/17/16.
 */
public class _286_WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        if (rooms.length == 0 || rooms[0].length == 0)
            return;
        int n = rooms.length;
        int m = rooms[0].length;

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (rooms[i][j] == 0) {
                    x.offer(i);
                    y.offer(j);
                }
        int[] dirx = {0, 0, 1, -1};
        int[] diry = {1, -1, 0, 0};
        while (!x.isEmpty()) {
            int currx = x.poll();
            int curry = y.poll();
            for (int k = 0; k < 4; ++k) {
                int newx = currx + dirx[k];
                int newy = curry + diry[k];
                if (newx >= 0 && newx < n && newy >= 0 && newy < m
                    && rooms[currx][curry] + 1 < rooms[newx][newy]) {
                    rooms[newx][newy] = rooms[currx][curry] + 1;
                    x.offer(newx);
                    y.offer(newy);
                }
            }
        }
    }
}
