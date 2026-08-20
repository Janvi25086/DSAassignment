import java.util.*;

public class Day55 {

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

    // Right View of Binary Tree
    static void rightView(Node root) {

        if (root == null) {
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node current = queue.poll();

                // Last node of every level
                if (i == size - 1) {
                    System.out.print(current.data + " ");
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
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

        rightView(root);

        sc.close();
    }
}
