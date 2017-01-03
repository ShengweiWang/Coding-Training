package Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by Shengwei_Wang on 10/24/16.
 */
public class _316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        boolean[] inStack = new boolean[512];
        int[] count = new int[512];
        for (int i = 0; i < s.length(); ++i)
            ++count[s.charAt(i)];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            --count[c];
            if (inStack[c])
                continue;
            while (stack.size() > 0 && count[stack.peek()] >= 1 && stack.peek() > c) {
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0)
            sb.append(stack.pop());
        return sb.reverse().toString();

    }
}
