package Google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shengwei_Wang on 10/19/16.
 */
public class _394_DecodeString {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> stackn = new ArrayDeque<>();
        String curr = "";
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                n = n * 10 + c - '0';
            else if (c == '[') {
                stack.push(curr);
                stackn.push(n);
                n = 0;
                curr = "";
            } else if (c == ']') {
                n = stackn.pop();
                String newCurr = stack.pop();
                for (int k = 0; k < n; ++k)
                    newCurr += curr;
                curr = newCurr;
                n = 0;
            } else {
                curr += c;
            }
        }
        return curr;
    }
}
