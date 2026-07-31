import java.util.Scanner;

public class Day35 {
    static final int MAX = 100;
    static int[] queue = new int[MAX];
    static int front = 0, rear = -1;

    // Enqueue operation
    static void enqueue(int value) {
        if (rear == MAX - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[++rear] = value;
    }

    // Display queue
    static void display() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            enqueue(sc.nextInt());
        }

        display();

        sc.close();
    }
}