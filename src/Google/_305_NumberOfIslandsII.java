package Google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/19/16.
 */
public class _305_NumberOfIslandsII {
    int[] father;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new LinkedList<>();
        if (m == 0 || n == 0)
            return ans;
        int mn = m * n;
        father = new int[mn];
        int[][] dir = {{1, -1, 0, 0}, {0, 0, 1, -1}};
        Arrays.fill(father, -1);
//        for (int i = 0; i < mn; ++i)
//            father[i] = i;
        int count = 0;
        for (int i = 0; i < positions.length; ++i) {
            int x = positions[i][0];
            int y = positions[i][1];
            int index = x * n + y;
            father[index] = index;

            ++count;

            for (int k = 0; k < 4; ++k) {
                int newx = dir[0][k] + x;
                int newy = dir[1][k] + y;
                if (newx >= 0 && newx < m && newy >= 0 && newy < n && father[newx * n + newy] != -1
                        && find(index) != find(newx * n + newy)) {
                    father[father[newx * n + newy]] = father[index];
                    --count;
                }
            }
            ans.add(count);
        }
        return ans;
    }

    int find (int index) {
        if (father[index] == index)
            return index;
        int temp = find(father[index]);
        father[index] = temp;
        return father[index];
    }
}
