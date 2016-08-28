/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int ans = 0;
        if ( n < 0)
            ++ans;
        for(int i = 0 ; i < 32; ++i){
            ans += (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
