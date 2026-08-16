import java.util.*;

class Day51 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert a value into BST
    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Find Lowest Common Ancestor
    static Node findLCA(Node root, int p, int q) {
        while (root != null) {

            // Both nodes are in the left subtree
            if (p < root.data && q < root.data) {
                root = root.left;
            }

            // Both nodes are in the right subtree
            else if (p > root.data && q > root.data) {
                root = root.right;
            }

            // Current node is the LCA
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Node root = null;

        // Build BST
        for (int i = 0; i < N; i++) {
            root = insert(root, sc.nextInt());
        }

        int p = sc.nextInt();
        int q = sc.nextInt();

        Node lca = findLCA(root, p, q);

        if (lca != null) {
            System.out.println(lca.data);
        }

        sc.close();
    }
}