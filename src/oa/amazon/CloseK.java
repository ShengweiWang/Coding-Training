package oa.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 12/16/16.
 */
public class CloseK {
    class Point {
        int x;
        int y;
    }

    public static Point[] closeK(Point[] points, int k) {
        if (k > points.length)
            return points;
        Arrays.sort(points, (a,b)-> ((a.x * a.x + a.y * a.y) - (b.x * b.x + b.y * b.y)));
        Point[] ans = new Point[k];
        for (int i = 0; i < k; ++i)
            ans[i] = points[i];
        return ans;
    }

    public static Point[] closeK_Priority(Point[] points, int k) {
        if (k > points.length)
            return points;
        PriorityQueue<Point> pq = new PriorityQueue<>((b,a)->((a.x * a.x + a.y * a.y) - (b.x * b.x + b.y * b.y)));
        //maximum heap
        for (Point point : points) {
            pq.offer(point);
            if (pq.size() > k)
                pq.poll();
        }
        Point[] ans = new Point[k];
        for (int i = 0; i < k; ++i)
            ans[i] = pq.poll();
        return ans;
    }
}
