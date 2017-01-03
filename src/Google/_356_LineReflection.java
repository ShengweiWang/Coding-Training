package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 10/25/16.
 */
public class _356_LineReflection {
    public boolean isReflected(int[][] points) {
        int leftx = Integer.MAX_VALUE;
        int rightx = Integer.MIN_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; ++i) {
            if (!map.containsKey(points[i][0]))
                map.put(points[i][0], new HashSet<>());
            map.get(points[i][0]).add(points[i][1]);
            leftx = Math.min(leftx, points[i][0]);
            rightx = Math.max(rightx, points[i][0]);
        }
        int sum = leftx + rightx;
        Set<Integer> emptySet = new HashSet<>();
        for (int i = 0 ; i < points.length; ++i) {
            if (!map.getOrDefault(sum - points[i][0], emptySet).contains(points[i][1]))
                return false;
        }
        return true;
    }
}
