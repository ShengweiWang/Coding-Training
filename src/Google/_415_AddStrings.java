package Google;

/**
 * Created by Shengwei_Wang on 10/21/16.
 */
public class _415_AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        for (int i = s1.length - 1; i >= 0; --i){
            s2[i + s2.length - s1.length] += (s1[i] - '0');
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = s2.length - 1; i >= 0; --i) {
            s2[i] += carry;
            if (s2[i] > '9') {
                carry = 1;
                s2[i] -= 10;
            } else
                carry = 0;
            sb.append(s2[i]);
        }
        if (carry > 0)
            sb.append(carry);
        sb.reverse();
        return sb.toString();
    }
}
