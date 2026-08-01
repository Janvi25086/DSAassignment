import java.util.Scanner;

public class Day36 {
    static final int MAX = 100;
    static int[] queue = new int[MAX];
    static int front = 0, rear = -1, size = 0;

    // Enqueue operation
    static void enqueue(int value) {
        if (size == MAX) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % MAX;
        queue[rear] = value;
        size++;
    }

    // Dequeue operation
    static void dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return;
        }
        front = (front + 1) % MAX;
        size--;
    }

    // Display queue
    static void display() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % MAX] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Enqueue elements
        for (int i = 0; i < n; i++) {
            enqueue(sc.nextInt());
        }

        int m = sc.nextInt();

        // Perform dequeue and re-enqueue (rotation)
        for (int i = 0; i < m; i++) {
            if (size > 0) {
                int value = queue[front];
                dequeue();
                enqueue(value);
            }
        }

        display();

        sc.close();
    }
}