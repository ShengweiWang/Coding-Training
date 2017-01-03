package Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 10/25/16.
 */
public class _310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] e = new Set[n];
        for (int i = 0; i < n; ++i)
            e[i] = new HashSet<>();
        for (int i = 0; i < edges.length; ++i) {
            e[edges[i][0]].add(edges[i][1]);
            e[edges[i][1]].add(edges[i][0]);
        }
        List<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (e[i].size() <= 1)
                leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<>();
            for (int i : leaves) {
                for (int j : e[i]) {
                    e[j].remove(i);
                    if (e[j].size() == 1)
                        newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
