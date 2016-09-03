/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _91_DecodeWays {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        if(s.charAt(0) == '0')
            return 0;
        if(s.length() == 1)
            return 1;
        int[] f = new int[s.length()];
        f[0] = 1;
        if(s.charAt(1) == '0')
            f[0] = 0;
        if((s.charAt(0) - '0')*10 + s.charAt(1) - '0' <= 26)
            f[1] = f[0] + 1;
        else
            f[1] = f[0];
        for(int i = 2; i < s.length(); ++i){
            if(s.charAt(i) == '0')
                f[i - 1] = 0;
            f[i] = f[i - 1];

            if((s.charAt(i - 1) - '0')*10 + s.charAt(i) - '0' <= 26)
                f[i] += f[i-2];
        }
        return f[s.length() - 1];
    }
}
