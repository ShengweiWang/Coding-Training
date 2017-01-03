package Google;

/**
 * Created by Shengwei_Wang on 10/24/16.
 */
public class _261_GraphValidTree {
    int[] f;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        f = new int[n];
        for (int i = 0; i < n; ++i)
            f[i] = i;
        for (int i = 0; i < edges.length; ++i) {
            if (find(edges[i][0]) == find(edges[i][1]))
                return false;
            f[f[edges[i][0]]] = f[edges[i][1]];
        }
        return true;
    }

    int find (int n) {
        if (n == f[n])
            return n;
        f[n] = find(f[n]);
        return f[n];
    }
}
