package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 9/28/16.
 */
public class _356_LineReflection {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < points.length; ++i){
            if(points[i][0] > max)
                max = points[i][0];
            if(points[i][0] < min)
                min = points[i][0];
            set.add(points[i][0] + "point" + points[i][1]);
        }
        int sum = max + min;
        for(int i = 0 ; i < points.length; ++i){
            String s = (sum - points[i][0]) + "point" + points[i][1];
            if(set.contains(s))
                continue;
            else
                return false;
        }
        return true;
    }
}
