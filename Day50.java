import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Day50 {

    // Insert a node into BST
    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Search for a value in BST
    static Node search(Node root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Inorder traversal
    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node root = null;

        // Construct BST
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }

        // Value to search
        int key = sc.nextInt();

        Node result = search(root, key);

        if (result == null) {
            System.out.println("-1");
        } else {
            // Print the subtree rooted at the found node
            inorder(result);
        }

        sc.close();
    }
}