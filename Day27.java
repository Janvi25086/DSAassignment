import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Day27 {

    // Create linked list
    static Node createList(int[] arr) {
        Node head = null, tail = null;

        for (int value : arr) {
            Node newNode = new Node(value);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Find intersection by value (as per problem statement)
    static int findIntersection(Node head1, Node head2) {
        HashSet<Integer> set = new HashSet<>();

        Node temp = head1;
        while (temp != null) {
            set.add(temp.data);
            temp = temp.next;
        }

        temp = head2;
        while (temp != null) {
            if (set.contains(temp.data)) {
                return temp.data;
            }
            temp = temp.next;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        Node head1 = createList(arr1);
        Node head2 = createList(arr2);

        int result = findIntersection(head1, head2);

        if (result == -1) {
            System.out.println("No Intersection");
        } else {
            System.out.println(result);
        }

        sc.close();
    }
}