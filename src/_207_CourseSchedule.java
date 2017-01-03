import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 11/7/16.
 */
public class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        Set<Integer>[] next = new Set[n];
        for (int i = 0; i < n; ++i)
            next[i] = new HashSet<>();
        int[] degree = new int[n];
        for (int[] pre : prerequisites) {
            if (!next[pre[1]].contains(pre[0])) {
                degree[pre[0]]++;
                next[pre[1]].add(pre[0]);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i)
            if (degree[i] == 0)
                q.offer(i);
        for (int i = 0; i < n; ++i) {
            if (q.size() == 0)
                return false;
            int cur = q.poll();
            for (int j : next[cur]) {
                if (--degree[j] == 0)
                    q.offer(j);
            }
        }
        return true;
    }
}
