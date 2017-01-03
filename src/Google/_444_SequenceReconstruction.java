package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 11/3/16.
 */
public class _444_SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        int n = org.length;
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, Set<Integer>> next = new HashMap<>();
        Set<Integer> checkSet = new HashSet<>();
        for (int i = 1; i <=n; ++i) {
            degree.put(i, 0);
            next.put(i, new HashSet<>());
        }
        for (int[] seq : seqs) {
            if (seq.length == 0)
                continue;
            for (int i = 0; i < seq.length - 1; ++i) {
                if (seq[i] > n || seq[i + 1] > n || seq[i] <= 0 || seq[i + 1] <= 0)
                    return false;
                checkSet.add(seq[i]);
                if (next.get(seq[i]).add(seq[i + 1]))
                    degree.put(seq[i + 1], degree.get(seq[i + 1]) + 1);
            }
            checkSet.add(seq[seq.length - 1]);

        }
        if (checkSet.size() != n)
            return false;
        boolean found = false;
        int j = -1;
        for (int i = 1; i <=n; ++i) {
            if (degree.get(i) == 0) {
                if (found)
                    return false;
                found = true;
                j = i;
            }
        }
        if (j == -1)
            return false;
        boolean[] visited = new boolean[n + 1];
        for (int k = 0; k < n; ++k) {
            if (j != org[k])
                return false;
            found = false;
            visited[j] = true;
            int nextj = j;
            for (int p : next.get(j)) {
                if (visited[p])
                    return false;
                int currd = degree.get(p);
                degree.put(p, currd - 1);
                if (currd == 1) {
                    if (found)
                        return false;
                    nextj = p;
                    found = true;
                }
            }
            if (nextj == j && k != n - 1)
                return false;
            else
                j = nextj;
        }
        return true;
    }
}
