/**
 * Created by Shengwei_Wang on 8/21/16.
 */
public class _258_AddDigits {
    public int addDigits(int num) {
        int ans;
        if (num == 0)
            return 0;
        ans = num % 9;
        if (ans == 0)
            return 9;
        else
            return ans;
    }
}
