import java.util.*;

class Sort_A_Stack {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (n-- > 0) {
            int x = in.nextInt();
            stack.push(x);
        }
        Solution(stack);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
        in.close();
    }

    static void Solution(Stack<Integer> stack) {
        if (stack.size() <= 1)
            return;
        int x = stack.pop();
        Solution(stack);
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty() && stack.peek() > x)
            temp.push(stack.pop());
        stack.push(x);
        while (!temp.isEmpty())
            stack.push(temp.pop());
    }
}