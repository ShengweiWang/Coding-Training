package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/25/16.
 */
public class _406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> { if (a[0] !=  b[0]) return b[0] - a[0]; else return a[1] - b[1];});
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; ++i) {
            list.add(people[i][1], people[i]);
        }
        int[][] ans = new int[people.length][2];
        int k = 0;
        for (int[] person : list) {
            ans[k][0] = person[0];
            ans[k][1] = person[1];
            ++k;
        }
        return ans;
    }
}
