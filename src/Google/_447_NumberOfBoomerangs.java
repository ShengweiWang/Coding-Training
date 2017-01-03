package Google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 11/10/16.
 */
public class _447_NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; ++i){
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                long mul = (long)(points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (long) (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
            for (long key : map.keySet()) {
                if (map.get(key) > 1) {
                    ans += map.get(key) * (map.get(key) - 1);
                }
            }
        }
        return ans;
    }
}
