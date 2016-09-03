import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _155_MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** initialize your data structure here. */
    public _155_MinStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if(s2.size() == 0 || s2.peek() > x)
            s2.push(x);
        else
            s2.push(s2.peek());
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
