import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Day29 {

    // Insert at end
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        return head;
    }

    // Rotate linked list to the right by k places
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Find length and last node
        Node last = head;
        int length = 1;

        while (last.next != null) {
            last = last.next;
            length++;
        }

        k = k % length;
        if (k == 0)
            return head;

        // Make circular
        last.next = head;

        // Find new last node
        int steps = length - k;
        Node newLast = head;

        for (int i = 1; i < steps; i++) {
            newLast = newLast.next;
        }

        // Update head
        Node newHead = newLast.next;
        newLast.next = null;

        return newHead;
    }

    // Print linked list
    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null;

        for (int i = 0; i < n; i++) {
            head = insert(head, sc.nextInt());
        }

        int k = sc.nextInt();

        head = rotateRight(head, k);

        printList(head);

        sc.close();
    }
}