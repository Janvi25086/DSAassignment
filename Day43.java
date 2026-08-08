import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Day43 {

    // Build Binary Tree from Level Order
    static Node buildTree(int[] arr, int n) {
        if (n == 0 || arr[0] == -1)
            return null;

        Node root = new Node(arr[0]);

        java.util.LinkedList<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < n) {
            Node current = queue.removeFirst();

            // Left Child
            if (i < n && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right Child
            if (i < n && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Inorder Traversal
    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, n);
        inorder(root);

        sc.close();
    }
}