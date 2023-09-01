import java.util.Scanner;

class Implement_Queue_using_Array {

    private static int queue[];
    private static int start, end, currSize, maxSize;

    public static void push(int newElement) {
        if (currSize == maxSize) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }
        if (end == -1) {
            start = 0;
            end = 0;
        } else
            end = (end + 1) % maxSize;
        queue[end] = newElement;
        System.out.println("The element pushed is " + newElement);
        currSize++;
    }

    public static int pop() {
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = queue[start];
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else
            start = (start + 1) % maxSize;
        currSize--;
        return popped;
    }

    public static int peek() {
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return queue[start];
    }

    public static int size() {
        return currSize;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        maxSize = n;
        queue = new int[n];
        System.out.println("Enter 1 for Push");
        System.out.println("Enter 2 for Peek");
        System.out.println("Enter 3 for Pop");
        System.out.println("Enter 4 for Exit");
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
                    System.exit(0);
            }
        }
    }
}