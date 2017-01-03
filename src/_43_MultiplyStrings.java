/**
 * Created by Shengwei_Wang on 11/4/16.
 */
public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] f = new int[n + m];
        for (int i = n - 1; i >= 0; --i)
            for (int j = m - 1; j >= 0; --j) {
                int mul = (num1.charAt(i) - '0' ) * (num2.charAt(j) - '0');
                f[i + j + 1] += mul;
                f[i + j] += f[i + j + 1] / 10;
                f[i + j + 1] %= 10;
            }
        StringBuilder sb = new StringBuilder();
        for (int a : f) {
            if (!((a == 0) && (sb.length() == 0)))
                sb.append(a);
        }
        if (sb.length() == 0)
            sb.append(0);
        return sb.toString();
    }
}
