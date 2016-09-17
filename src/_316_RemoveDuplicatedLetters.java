import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _316_RemoveDuplicatedLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[512];
        boolean[] visited = new boolean[512];
        for(int i = 0; i < s.length(); ++i)
            ++count[s.charAt(i)];
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            --count[s.charAt(i)];
            if(visited[s.charAt(i)])
                continue;
            while(!stack.isEmpty() && stack.peek() > s.charAt(i) && count[stack.peek()] > 0){
                visited[stack.peek()] = false;
                stack.pop();
            }
            visited[s.charAt(i)] = true;
            stack.push(s.charAt(i));

        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.reverse().toString();
    }
}
