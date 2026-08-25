import java.util.*;

public class Day60 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build binary tree from level-order traversal
    static Node buildTree(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        Node root = new Node(arr[0]);

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            Node current = queue.poll();

            // Left child
            if (i < arr.length) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
                i++;
            }

            // Right child
            if (i < arr.length) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
                i++;
            }
        }

        return root;
    }

    // Check Min-Heap property
    static boolean isMinHeap(Node root) {

        if (root == null) {
            return true;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        boolean nullFound = false;

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            // Check left child
            if (current.left != null) {

                // Parent must be <= child
                if (current.data > current.left.data) {
                    return false;
                }

                // Once a node has no left child,
                // all following nodes must have no children
                if (nullFound) {
                    return false;
                }

                queue.offer(current.left);

            } else {
                nullFound = true;
            }

            // Check right child
            if (current.right != null) {

                // A right child without a left child is invalid
                if (current.left == null) {
                    return false;
                }

                // Parent must be <= child
                if (current.data > current.right.data) {
                    return false;
                }

                if (nullFound) {
                    return false;
                }

                queue.offer(current.right);

            } else {
                nullFound = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        if (isMinHeap(root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}