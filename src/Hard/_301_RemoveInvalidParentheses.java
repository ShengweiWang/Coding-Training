package Hard;

import java.util.*;

/**
 * Created by Shengwei_Wang on 11/2/16.
 */
public class _301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> state = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> res = new LinkedList<>();
        state.add(s);
        q.offer(s);
        boolean found = false;
        while(!q.isEmpty()){
            String curr = q.poll();
            if (isValid(curr)) {
                found = true;
                res.add(curr);
            }
            if (found)
                continue;
            for (int i = 0; i < curr.length(); ++i) {
                if (curr.charAt(i) == '(' || curr.charAt(i) == ')') {
                    String next = curr.substring(0, i) + curr.substring(i + 1);
                    if (!state.contains(next))
                        q.offer(next);
                }
            }
        }
        return res;
    }
    boolean isValid (String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                ++count;
            else if (s.charAt(i) == ')')
                if (--count < 0)
                    return false;
        }
        return count == 0;
    }

}
