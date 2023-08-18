import java.util.*;

class MinStack {
    Stack<Integer> s;
    Stack<Integer> a;

    public MinStack() {
        s = new Stack<>();
        a = new Stack<>();
    }

    public void push(int val) {
        if (s.isEmpty())
            a.push(val);
        else if (a.peek() >= val)
            a.push(val);
        s.push(val);
    }

    public void pop() {
        int x = s.pop();
        if (a.peek() == x)
            a.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return a.peek();
    }
}