import java.util.*;

class Implement_Queue_Using_Stack {
    Stack<Integer> inp;
    Stack<Integer> out;

    public Implement_Queue_Using_Stack() {
        inp = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        inp.push(x);
    }

    public int pop() {
        if (!out.isEmpty())
            return out.pop();
        else {
            while (!inp.isEmpty())
                out.push(inp.pop());
            return out.pop();
        }
    }

    public int peek() {
        if (!out.isEmpty())
            return out.peek();
        else {
            while (!inp.isEmpty())
                out.push(inp.pop());
            return out.peek();
        }
    }

    public boolean empty() {
        return inp.isEmpty() && out.isEmpty();
    }
}