/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _202_HappyNumber {
    public boolean isHappy(int n) {
        boolean[] flag = new boolean[1000];
        while(n != 1){
            int k = 0;
            while(n>0){
                k += (n % 10) * (n % 10);
                n /= 10;
            }
            if (flag[k])
                return false;
            else
                flag[k] = true;
            n = k;
        }
        return true;
    }
}
