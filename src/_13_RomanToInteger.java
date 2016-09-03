/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _13_RomanToInteger {
    public int romanToInt(String s) {
        int[] f = new int[512];
        f['I'] = 1;
        f['V'] = 5;
        f['X'] = 10;
        f['L'] = 50;
        f['C'] = 100;
        f['D'] = 500;
        f['M'] = 1000;
        int ans = 0;
        for(int i = 0; i < s.length() - 1; ++i){
            if(f[s.charAt(i)] < f[s.charAt(i+1)])
                ans -= f[s.charAt(i)];
            else
                ans += f[s.charAt(i)];
        }
        return ans + f[s.charAt(s.length() - 1)];
    }
}
