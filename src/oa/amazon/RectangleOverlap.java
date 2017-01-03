package oa.amazon;

import java.awt.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 12/17/16.
 */
public class RectangleOverlap {
    public static boolean isOverLap(Rectangle a, Rectangle b) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        if (a.leftTop.x > b.leftTop.x) {
            Rectangle temp = a;
            a = b;
            b = temp;
        }
        if (b.leftTop.x > a.bottomRight.x || b.leftTop.y < a.bottomRight.y)
            return false;
        if (b.bottomRight.y <= a.leftTop.y)
            return true;
        else
            return false;

    }
    class Rectangle {
        Point leftTop;
        Point bottomRight;
        public Rectangle (Point leftTop, Point bottomRight) {
            this.leftTop = leftTop;
            this.bottomRight = bottomRight;
        }
    }

    class Point {
        int x, y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
