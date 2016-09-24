/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _302_SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int n = image.length;
        if(n == 0)
            return 0;
        int m = image[0].length;

        int top = search(true, true, 0, x, 0, m, image);         //row [0, x] find first '1'
        int bottom = search(true, false, x, n - 1, 0, m, image); //row [x, n-1] find first '0'
        int left = search(false, true, 0, y, 0, n, image);       //col [0, y] find first '1'
        int right = search(false, false, y, m - 1, 0, n, image); //col [y, m-1] find first ''
        System.out.println(top+" " + bottom+ " " + left + " " + right);
        return (right - left) * (bottom - top);
    }

    int search(boolean isRow, boolean self, int start, int end, int min, int max, char[][]image){
        if(self){
            if(find(isRow, start, min, max, image))
                return start;
        } else {
            if(find(isRow, end, min, max, image))
                return end + 1;
        }
        int l = start;
        int r = end;
        int mid;
        while(l < r){
            // System.out.println("before " + isRow + " " + self + " " + start + " " + end + " " + l + " " + r);
            mid = l + (r - l)/2;
            if(find(isRow, mid, min, max, image) ^ !self)
                r = mid;
            else
                l = mid + 1;
            // System.out.println(isRow + " " + self + " " + start + " " + end + " " + l + " " + r+ " "+mid+" "+find(isRow, mid, min, max, image));
        }
        return l;
    }
    boolean find(boolean isRow, int x, int min, int max, char[][] image){
        if(isRow){
            for(int i = min; i < max; ++i)
                if(image[x][i] == '1')
                    return true;
            return false;
        } else {
            for(int i = min; i < max; ++i)
                if(image[i][x] == '1')
                    return true;
        }
        return false;
    }
}
