/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _246_StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        char[] f = new char[256];
        f['9'] = '6';
        f['6'] = '9';
        f['0'] = '0';
        f['8'] = '8';
        f['1'] = '1';
        int n = num.length() - 1;
        for(int i = 0; i <= n/2; ++i)
            if(f[num.charAt(i)] != num.charAt(n-i))
                return false;
        return true;
    }
}
