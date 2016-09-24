import java.util.*;

/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> state = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        state.add(s);
        q.offer(s);
        boolean found = false;
        while(!q.isEmpty()){
            String cur = q.poll();
            if(valid(cur)){
                found = true;
                res.add(cur);
            }
            if(found)
                continue;
            for(int i = 0; i < cur.length(); ++i){
                if(cur.charAt(i) != '(' && cur.charAt(i) != ')')
                    continue;
                String build = cur.substring(0, i) + cur.substring(i + 1);
                if(state.contains(build))
                    continue;
                q.offer(build);
                state.add(build);
            }
        }
        return res;
    }

    boolean valid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(')
                ++count;
            else if (s.charAt(i) == ')' && count-- == 0)
                return false;
        }
        return count == 0;
    }
}
