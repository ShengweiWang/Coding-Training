/**
 * Created by Shengwei_Wang on 9/7/16.
 */
public class _261_GraphValidTree {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1)
            return false;
        parent = new int[n];
        for(int i = 0; i < n; ++i)
            parent[i] = i;

        for(int i = 0; i < n - 1; ++i){
            int fl = find(edges[i][0]);
            int fr = find(edges[i][1]);
            if(fl == fr)
                return false;
            else
                parent[fr] = fl;
        }
        return true;

    }
    public int find(int n){
        if(parent[n] == n)
            return n;
        int temp = find(parent[n]);
        if(parent[n] != temp)
            parent[n] = temp;
        return temp;
    }
}
