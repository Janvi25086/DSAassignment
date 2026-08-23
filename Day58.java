import java.util.*;

public class Day58 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int preIndex = 0;

    // Store inorder values and their indices
    static HashMap<Integer, Integer> inorderMap = new HashMap<>();

    // Build tree from preorder and inorder
    static Node buildTree(int[] preorder, int left, int right) {

        // No elements in this subtree
        if (left > right) {
            return null;
        }

        // First element in preorder is the root
        int rootValue = preorder[preIndex++];

        Node root = new Node(rootValue);

        // Find root in inorder
        int rootIndex = inorderMap.get(rootValue);

        // Build left subtree
        root.left = buildTree(preorder, left, rootIndex - 1);

        // Build right subtree
        root.right = buildTree(preorder, rootIndex + 1, right);

        return root;
    }

    // Postorder traversal
    static void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);

        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] preorder = new int[N];
        int[] inorder = new int[N];

        // Read preorder
        for (int i = 0; i < N; i++) {
            preorder[i] = sc.nextInt();
        }

        // Read inorder
        for (int i = 0; i < N; i++) {
            inorder[i] = sc.nextInt();
        }

        // Store inorder indices
        for (int i = 0; i < N; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Construct tree
        Node root = buildTree(preorder, 0, N - 1);

        // Print postorder
        postorder(root);

        sc.close();
    }
}