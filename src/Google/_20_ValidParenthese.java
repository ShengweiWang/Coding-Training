package Google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _20_ValidParenthese {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if( c == '(' || c == '{' || c =='[')
                stack.push(c);
            if ( c == ')')
                if ( stack.size() == 0 || stack.pop() != '(')
                    return false;
            if ( c == '}')
                if ( stack.size() == 0 || stack.pop() != '{')
                    return false;
            if ( c == ']')
                if ( stack.size() == 0 || stack.pop() != '[')
                    return false;
        }
        if (stack.size() > 0)
            return false;
        else
            return true;
    }
}
