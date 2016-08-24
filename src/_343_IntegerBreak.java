/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _343_IntegerBreak {
    public int integerBreak(int n){
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        if(n == 3)
            return 2;
        if(n % 3 == 0)
            return (int)Math.pow(3, n/3);
        if(n % 3 == 1)
            return ((int)Math.pow(3, n/3 - 1)) *4;
        return 2*(int)Math.pow(3, n/3);
    }
}
