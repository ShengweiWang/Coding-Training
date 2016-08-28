import java.util.HashMap;

/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _149_MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if(points.length <= 2)
            return points.length;
        int res = 0;
        int ans;
        int ver;
        int self;
        for(int i = 0; i < points.length; ++i){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            ans = 0;
            ver = 0;
            self = 1;
            for(int j = i + 1; j < points.length; ++j){
                if(points[j].x == points[i].x) {
                    if (points[i].y == points[j].y)
                        ++self;
                    else {
                        ++ver;
                        if (ver > ans)
                            ans = ver;
                    }
                }
                else {
                    int temp = 10000 * (points[j].y - points[i].y)/(points[j].x - points[i].x);
                    if(hashMap.containsKey(temp))
                        hashMap.replace(temp, hashMap.get(temp) + 1);
                    else
                        hashMap.put(temp, 1);
                    if (hashMap.get(temp) > ans)
                        ans = hashMap.get(temp);
                }
            }
            if( ans + self > res)
                res = ans + self;
        }
        return res;
    }
}
