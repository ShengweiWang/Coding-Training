/**
 * Created by Shengwei_Wang on 9/19/16.
 */
public class _233_NumberOfDigitOne {
    public int countDigitOne(int n) {
        if(n <= 0)
            return 0;
        int val = n;
        int sig = 1;
        while(val >= 10){
            sig *= 10;
            val /= 10;
        }
        int constant;
        if(val == 1)
            constant = n % sig + 1;
        else
            constant = sig;
        return constant + val * countDigitOne(sig - 1) + countDigitOne(n % sig);
    }
}
