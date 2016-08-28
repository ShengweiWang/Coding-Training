/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n -1)) == 0);
    }
}
