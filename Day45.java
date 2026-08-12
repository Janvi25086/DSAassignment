import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Day45 {

    // Build Binary Tree from Level Order
    static Node buildTree(int[] arr, int n) {
        if (n == 0 || arr[0] == -1)
            return null;

        Node root = new Node(arr[0]);
        LinkedList<Node> queue = new LinkedList<>();
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

    // Find Height of Tree
    static int height(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, n);

        System.out.println(height(root));

        sc.close();
    }
}