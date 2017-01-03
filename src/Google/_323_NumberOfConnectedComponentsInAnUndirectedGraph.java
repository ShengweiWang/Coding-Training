package Google;

/**
 * Created by Shengwei_Wang on 10/24/16.
 */
public class _323_NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] f = new int[n];
        for (int i = 0; i < edges.length; ++i) {
            f[find(edges[i][0], f)] = f[find(edges[i][1], f)];
        }
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (i == f[i])
                ++count;
        return count;

    }

    int find (int i, int[] f) {
        if (i == f[i])
            return i;
        int father = find(f[i], f);
        f[i] = father;
        return father;
    }
}
