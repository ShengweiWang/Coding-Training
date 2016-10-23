package Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by Shengwei_Wang on 10/16/16.
 */
public class _155_MinStack {
    Deque<Integer> element;
    Deque<Integer> min;
    /** initialize your data structure here. */
    public _155_MinStack() {
        element = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    public void push(int x) {
        element.push(x);
        if (min.size() == 0)
            min.push(x);
        else
            min.push(Math.min(x, min.getFirst()));
    }

    public void pop() {
        element.pop();
        min.pop();
    }

    public int top() {
        return element.getFirst();
    }

    public int getMin() {
        return min.getFirst();
    }
}
