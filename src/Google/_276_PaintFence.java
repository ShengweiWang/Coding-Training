package Google;

/**
 * Created by Shengwei_Wang on 10/19/16.
 */
public class _276_PaintFence {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        int left = k;
        int right = 0;
        for (int i = 1; i < n; ++i){
            int newLeft = (right + left) * (k - 1);
            int newRight = left;
            left = newLeft;
            right = newRight;
        }
        return left + right;
    }
}
