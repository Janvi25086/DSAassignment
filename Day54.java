import java.util.*;

public class Day54 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build binary tree from level-order traversal
    static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            Node current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Zigzag traversal
    static void zigzagTraversal(Node root) {

        if (root == null) {
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            int[] level = new int[size];

            for (int i = 0; i < size; i++) {

                Node current = queue.poll();

                // Store according to direction
                if (leftToRight) {
                    level[i] = current.data;
                } else {
                    level[size - 1 - i] = current.data;
                }

                // Add children
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Print current level
            for (int value : level) {
                System.out.print(value + " ");
            }

            // Change direction
            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        zigzagTraversal(root);

        sc.close();
    }
}
