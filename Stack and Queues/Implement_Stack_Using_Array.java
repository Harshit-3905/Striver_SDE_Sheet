import java.util.Scanner;

class Implement_Stack_Using_Array {
    static int stack[];
    static int capacity;
    static int i = -1;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        capacity = n;
        stack = new int[n];
        System.out.println("Enter 1 for Push");
        System.out.println("Enter 2 for Peek");
        System.out.println("Enter 3 for Pop");
        System.out.println("Enter 4 for Contents of the Stack");
        System.out.println("Enter 5 for Exit");
        while (true) {
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Element to Push");
                    int x = in.nextInt();
                    push(x);
                    break;
                case 2:
                    System.out.println(peek());
                    break;
                case 3:
                    System.out.println(pop());
                    break;
                case 4:
                    contents();
                    break;
            }
            if (choice == 5)
                break;
        }
        in.close();
    }

    static void push(int x) {
        if (i > capacity) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++i] = x;
    }

    static int peek() {
        if (i == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[i];
    }

    static int pop() {
        if (i == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[i--];
    }

    static void contents() {
        for (int j = 0; j <= i; j++)
            System.out.print(stack[j] + " ");
        System.out.println();
    }
}