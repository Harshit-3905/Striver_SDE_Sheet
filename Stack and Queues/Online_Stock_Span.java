import java.util.*;

class StockSpanner {
    Stack<Pair> s;

    public StockSpanner() {
        s = new Stack<>();
    }

    public int next(int price) {
        int x = 1;
        while (!s.isEmpty() && s.peek().x <= price)
            x += s.pop().y;
        s.push(new Pair(price, x));
        return x;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
