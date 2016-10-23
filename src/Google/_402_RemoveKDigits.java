package Google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shengwei_Wang on 10/21/16.
 */
public class _402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                --k;
                stack.pop();
            }
            if (c != '0' || !stack.isEmpty())
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && k > 0) {
            --k;
            stack.pop();
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        if (sb.length() == 0)
            sb.append(0);
        return sb.toString();
    }
}
