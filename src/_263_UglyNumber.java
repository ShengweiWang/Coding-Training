/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _263_UglyNumber {
    public boolean isUgly(int num) {
        while(num % 2 == 0)
            num /=2;
        while(num % 3 == 0)
            num /=3;
        while(num % 5 == 0)
            num /=5;
        if(num == 1)
            return true;
        else
            return false;
    }
}
