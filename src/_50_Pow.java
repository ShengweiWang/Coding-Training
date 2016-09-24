/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _50_Pow {
    public double myPow(double x, int n) {
        if(n < 0)
            return 1/x/myPow(x, -(n+1));
        if(n == 0)
            return 1;
        else if (n == 1)
            return x;
        double ans = myPow(x, n >>1);
        ans *= ans;
        if((n & 1) == 1){
            return x * ans;
        } else
            return ans;
    }
}
