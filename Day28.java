import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Day28 {

    // Insert node at the end of the circular linked list
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return head;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;

        return head;
    }

    // Traverse and print the circular linked list
    static void traverse(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null;

        for (int i = 0; i < n; i++) {
            head = insert(head, sc.nextInt());
        }

        traverse(head);

        sc.close();
    }
}
