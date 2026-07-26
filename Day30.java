import java.util.Scanner;

class Node {
    int coeff;
    int exp;
    Node next;

    Node(int coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
        this.next = null;
    }
}

public class Day30 {

    // Insert node at the end
    static Node insert(Node head, int coeff, int exp) {
        Node newNode = new Node(coeff, exp);

        if (head == null) {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Print polynomial
    static void printPolynomial(Node head) {
        Node temp = head;

        while (temp != null) {
            if (temp.exp == 0) {
                System.out.print(temp.coeff);
            } else if (temp.exp == 1) {
                System.out.print(temp.coeff + "x");
            } else {
                System.out.print(temp.coeff + "x^" + temp.exp);
            }

            if (temp.next != null) {
                System.out.print(" + ");
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null;

        for (int i = 0; i < n; i++) {
            int coeff = sc.nextInt();
            int exp = sc.nextInt();
            head = insert(head, coeff, exp);
        }

        printPolynomial(head);

        sc.close();
    }
}