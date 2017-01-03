/**
 * Created by Shengwei_Wang on 11/3/16.
 */
public class _29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        int shift = 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long i = 1;
        if (dividend < 0)
            i = - i;
        if (divisor < 0)
            i = - i;
        while (a >= (b << shift)) {
            ++shift;
        }
        long ans = 0;
        while (a >= b) {
            if (a >= (b << shift)) {
                a -= (b << shift);
                ans += (long)1 << shift;
            } else {
                --shift;
            }
        }
        ans *= i;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)ans;
    }
}
