package oa.amazon.important9;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 12/31/16.
 */
public class KClosestPoints {
    public static Point[] findClosetPoint(Point[] array, Point origin, int k) {
        if (k <= 0)
            return new Point[0];
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)-> distance(a, origin) - distance(b, origin));
        for (Point point : array) {
            pq.offer(point);
        }

        Point[] ans = new Point[Math.min(k, array.length)];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    static int distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }


    class Point {
        int x, y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
