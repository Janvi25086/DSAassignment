import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Day24 {

    // Insert at end
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Delete first occurrence of key
    static Node delete(Node head, int key) {
        if (head == null)
            return null;

        // If key is in first node
        if (head.data == key)
            return head.next;

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.data == key) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    // Print linked list
    static void print(Node head) {
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

        int key = sc.nextInt();

        head = delete(head, key);

        print(head);

        sc.close();
    }
}
