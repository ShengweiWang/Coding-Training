import java.util.Stack;

/**
 * Created by Shengwei_Wang on 8/29/16.
 */
public class _224_BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int cur = 0;
        for(int i = 0; i < s.length(); ++i){
//            System.out.println("~~~~");
//            System.out.println(i);
//            System.out.println(operands.size());
//            System.out.println(operator.size());
//            if(operator.size() > 0){
//                System.out.println(operator.peek());
//            }
//            if(operands.size() > 0){
//                System.out.println(operands.peek());
//            }
            char c = s.charAt(i);
            if(c == ' ')
                continue;
            else if (c == '+' || c == '-' || c == ')'){
//                operands.push(cur);
                while(operator.size() > 0 && operator.peek() != '('){
                    if(operator.pop() == '+'){
                        cur = operands.pop() + cur;
                    } else
                        cur = operands.pop() - cur;
                }
                if(operator.size() > 0 && operator.peek() == '(' && c == ')'){
                    operator.pop();
                    while(operator.size() > 0 && operator.peek() != '('){
                        if(operator.pop() == '+'){
                            cur = operands.pop() + cur;
                        } else
                            cur = operands.pop() - cur;
                    }
                }
                if(c != ')') {
                    operands.push(cur);
                    cur = 0;
                    operator.push(c);
                }
            } else if (c == '(')
                operator.push(c);
            else {
                cur = cur * 10 + s.charAt(i) - '0';
            }
        }

        while(operator.size() > 0){
            if(operator.pop() == '+'){
                cur = operands.pop() + cur;
            } else
                cur = operands.pop() - cur;
        }
        return cur;

    }
}
