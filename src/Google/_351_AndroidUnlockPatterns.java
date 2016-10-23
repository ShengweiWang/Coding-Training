package Google;

/**
 * Created by Shengwei_Wang on 10/20/16.
 */
public class _351_AndroidUnlockPatterns {
    int count;
    boolean[] visited;
    int[][] prev;
    int m;
    int n;
    public int numberOfPatterns(int m, int n) {
        this.m = m;
        this.n = n;
        visited = new boolean[9];
        prev = new int[][]{
                {0, 0, 1, 0, 0, 0, 3, 0, 4},
                {1, 1, 1, 1, 1, 1, 1, 4 ,1},
                {1, 2, 2, 2, 2, 2, 4, 2, 5},
                {3, 3, 3, 3, 3, 4, 3, 3, 3},
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
                {5, 5, 5, 4, 5, 5, 5, 5, 5},
                {3, 6, 4, 6, 6, 6, 6, 6, 7},
                {7, 4, 7, 7, 7, 7, 7, 7, 7},
                {4, 8, 5, 8, 8, 8, 7, 8, 8}
        };

        for (int i = 0; i < 9; ++i) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }
        return count;
    }

    void dfs(int curr, int level) {
        if (level == n) {
            ++count;
            return;
        }

        if (level >= m) {
            ++count;
        }
        for (int i = 0; i < 9; ++i) {
            if (!visited[i] && visited[prev[curr][i]]) {
                visited[i] = true;
                dfs(i, level + 1);
                visited[i] = false;
            }
        }
    }
}
