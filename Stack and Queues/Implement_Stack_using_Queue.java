import java.util.*;

class Implement_Stack_using_Queue {
    Queue<Integer> q;

    public Implement_Stack_using_Queue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        int x = q.size();
        for (int i = 1; i < x; i++)
            q.add(q.poll());
        return q.poll();
    }

    public int top() {
        int x = q.size();
        for (int i = 1; i < x; i++)
            q.add(q.poll());
        int y = q.peek();
        q.add(q.poll());
        return y;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */