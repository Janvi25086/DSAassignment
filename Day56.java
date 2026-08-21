import java.util.*;

public class Day56 {

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

    // Check whether two subtrees are mirrors
    static boolean isMirror(Node left, Node right) {

        // Both are empty
        if (left == null && right == null) {
            return true;
        }

        // One is empty
        if (left == null || right == null) {
            return false;
        }

        // Values must be equal and subtrees must be mirrors
        return left.data == right.data
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    // Check symmetry
    static boolean isSymmetric(Node root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        if (isSymmetric(root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}