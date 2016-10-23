package Google;

/**
 * Created by Shengwei_Wang on 10/22/16.
 */
public class _397_IntegerReplacement {
    public int integerReplacement(int n) {
        long curr = n;
        int k = 0;
        while (curr != 1) {
            ++k;
            if ((curr & 1) == 0)
                curr >>= 1;
            else {
                if (curr == 3)
                    return k + 1;
                if (((curr >> 1) & 1) == 1)
                    curr += 1;
                else
                    curr -= 1;
            }
        }
        return k;
    }
}
