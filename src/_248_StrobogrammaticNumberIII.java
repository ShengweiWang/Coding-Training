/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _248_StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int ans = 0;
        for(int i = low.length(); i < high.length(); ++i) {
            ans += fromLen(i);
        }
        ans += fromNum(high);
        ans -= fromNum(low);
        if(selfJudge(low))
            ++ans;
        return ans;
    }

    boolean selfJudge(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char c = s.charAt(i);
            char t = s.charAt(j);
            if(c == '0') {
                if (t != '0')
                    return false;
            } else if (c == '1') {
                if (t != '1')
                    return false;
            } else if (c == '6') {
                if (t != '9')
                    return false;
            } else if (c == '8') {
                if (t != '8')
                    return false;
            } else if (c == '9') {
                if (t != '6')
                    return false;
            } else
                return false;
            ++i;
            --j;
        }
        if(i == j){
            char c = s.charAt(i);
            if(c != '0' && c != '1' && c != '8')
                return false;
        }
        return true;
    }
    int fromLen(int k) {
        if(k == 0)
            return 0;
        if(k % 2 == 0)
            return 4 * (int)Math.pow(5, k/2 - 1);
        else
            return 4 * 3 * (int)Math.pow(5, k/2 - 1);
    }

    int fromNum(String s) {
        if(s.length() == 0)
            return 0;
        char c = s.charAt(0);
        if(s.length() == 1){
            if(c >= '8')
                return 3;
            else if (c >= '1')
                return 2;
            else
                return 1;
        }
        char t = s.charAt(s.length() - 1);
        if( c == '9' && t >= '6')
            return 4 * fromLen(s.length() - 2) + fromNum(s.substring(1, s.length() - 1));
        else if (c > '8' || (c == '8' && t >'8'))
            return 4 * fromLen(s.length() - 2);
        else if (c == '8' && t == '8')
            return 3 * fromLen(s.length() - 2) + fromNum(s.substring(1, s.length() - 1));
        else if (c > '6' || ( c == '6' && t > '9'))
            return 3 * fromLen(s.length() - 2);
        else if (c == '6' && t == '9')
            return 2 * fromLen(s.length() - 2) + fromNum(s.substring(1, s.length() - 1));
        else if (c > '1' || ( c == '1' && t > '1'))
            return 2 * fromLen(s.length() - 2);
        else if (c == '1' && t == '1')
            return fromLen(s.length() - 2) + fromNum(s.substring(1, s.length() - 1));
        else if (c > '0' || ( c == '0' && t > '0'))
            return fromLen(s.length() - 2);
        else return fromNum(s.substring(1, s.length() - 1));
    }
}
