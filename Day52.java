import java.util.*;

public class Day52 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Build binary tree from level-order traversal
    static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            Node current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Find Lowest Common Ancestor
    static Node findLCA(Node root, int p, int q) {

        // If tree is empty or current node is p or q
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        // Search in left subtree
        Node left = findLCA(root.left, p, q);

        // Search in right subtree
        Node right = findLCA(root.right, p, q);

        // p and q are in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Return the subtree where p or q was found
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of nodes
        int N = sc.nextInt();

        // Level-order traversal
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Two nodes
        int p = sc.nextInt();
        int q = sc.nextInt();

        // Build the tree
        Node root = buildTree(arr);

        // Find LCA
        Node lca = findLCA(root, p, q);

        // Print LCA
        if (lca != null) {
            System.out.println(lca.data);
        }

        sc.close();
    }
}