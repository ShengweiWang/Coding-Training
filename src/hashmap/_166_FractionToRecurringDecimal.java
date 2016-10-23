package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _166_FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator;
        long d = denominator;
        String sig = "";
        if(n == 0)
            return "0";
        if(n < 0 && d < 0){
            n = -n;
            d = -d;
        } else if(n < 0 || d < 0){
            n = Math.abs(n);
            d = Math.abs(d);
            sig = "-";
        }

        String left = sig + Long.toString(n/d);
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        n = n % d;
        int k = 0;
        String right = "";
        int i = 0;
        while(n != 0){
            n *= 10;
            if(map.containsKey(n)){
                right = right.substring(0, map.get(n)) + "(" + right.substring(map.get(n)) + ")";
                break;
            } else {
                map.put(n, i);
            }
            ++i;
            right += Long.toString(n/d);
            n %= d;
        }
        if(right.length() == 0)
            return left;
        else
            return left + "." + right;
    }
}
