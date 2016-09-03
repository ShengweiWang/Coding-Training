/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _342_PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num == 0)
            return false;
        int large = 1073741824;
        if(large % num != 0)
            return false;
        if((int)Math.sqrt(num) *(int)Math.sqrt(num) != num)
            return false;
        else
            return true;
    }
}
