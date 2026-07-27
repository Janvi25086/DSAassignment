import java.util.Scanner;

public class Day31 {
    static final int MAX = 100;
    static int[] stack = new int[MAX];
    static int top = -1;

    // Push operation
    static void push(int value) {
        if (top == MAX - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
        }
    }

    // Pop operation
    static void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top--]);
        }
    }

    // Display operation
    static void display() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int value = sc.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    display();
                    break;

                default:
                    System.out.println("Invalid Operation");
            }
        }

        sc.close();
    }
}