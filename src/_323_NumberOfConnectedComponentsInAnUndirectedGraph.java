/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _323_NumberOfConnectedComponentsInAnUndirectedGraph {
    int[] f;
    public int countComponents(int n, int[][] edges) {
        f = new int[n];
        for(int i = 0; i < n; ++i)
            f[i] = i;
        for(int i = 0; i < edges.length; ++i){
            f[find(edges[i][0])] = f[find(edges[i][1])];
        }
        int count = 0;
        for(int i = 0; i < n; ++i){
            if(find(i) == i)
                ++count;
        }
        return count;
    }

    int find(int n){
        if(f[n] == n)
            return n;
        else {
            f[n] = find(f[n]);
            return f[n];
        }
    }
}
