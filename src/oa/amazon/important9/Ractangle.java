package oa.amazon.important9;

import java.awt.*;

/**
 * Created by Shengwei_Wang on 1/1/17.
 */
public class Ractangle {
    public static boolean isOverLap(Rectangle a, Rectangle b){
        if (a.leftTop.x > b.bottomRight.x || b.leftTop.x > a.bottomRight.x)
            return false;
        if (a.bottomRight.y > b.leftTop.y || b.bottomRight.y > a.leftTop.y)
            return false;
        return true;
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
