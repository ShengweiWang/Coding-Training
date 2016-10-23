package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 10/18/16.
 */
public class _166_FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        long n = numerator;
        long d = denominator;
        boolean flag = false;
        String s = "";
        if (n < 0) {
            n = -n;
            flag = !flag;
        }
        if (d < 0) {
            d = -d;
            flag = !flag;
        }
        if (flag)
            s += "-";
        long before = n/d;
        n = n % d;
        s += Long.toString(before);
        if (n == 0)
            return s;
        s += ".";
        Map<Long, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        int k = 0;
        while ( !map.containsKey(n)) {
            map.put(n, k);
            n *= 10;
            sb.append(n / d);
            n %= d;
            if (n == 0)
                return s + sb.toString();
            ++k;
        }
        s += sb.substring(0, map.get(n)) + "(" + sb.substring(map.get(n)) + ")";
        return s;

    }

    public static void main (String[] argvs) {
        _166_FractionToRecurringDecimal solution = new _166_FractionToRecurringDecimal();
        System.out.println(solution.fractionToDecimal(1, 2));
        System.out.println(solution.fractionToDecimal(1, 8));
        System.out.println(solution.fractionToDecimal(11, 8));
        System.out.println(solution.fractionToDecimal(1, 7));
        System.out.println(solution.fractionToDecimal(20, 4));
        System.out.println(solution.fractionToDecimal(2, 1));
        System.out.println(solution.fractionToDecimal(1, 6));
        System.out.println(solution.fractionToDecimal(2, 3));
    }
}
