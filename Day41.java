import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;

    // Enqueue operation
    void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue operation
    void dequeue() {
        if (front == null) {
            System.out.println(-1);
            return;
        }

        System.out.println(front.data);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }
}

public class Day41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue queue = new Queue();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String operation = sc.next();

            if (operation.equals("enqueue")) {
                int value = sc.nextInt();
                queue.enqueue(value);
            } else if (operation.equals("dequeue")) {
                queue.dequeue();
            }
        }

        sc.close();
    }
}