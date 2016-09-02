import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/1/16.
 */

public class _232_ImplementQueueUsingStacks {
    Stack<Integer> stack;
    public _232_ImplementQueueUsingStacks(){
        stack = new Stack<>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> aux = new Stack<>();
        while(!stack.isEmpty()){
            aux.push(stack.peek());
            stack.pop();
        }
        stack.push(x);
        while(!aux.isEmpty()){
            stack.push(aux.peek());
            aux.pop();
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stack.isEmpty());
    }
}