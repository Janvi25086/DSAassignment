import java.util.*;

public class Day59 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int postIndex;
    static HashMap<Integer, Integer> inorderMap = new HashMap<>();

    // Build tree from inorder and postorder
    static Node buildTree(int[] inorder, int[] postorder, int left, int right) {

        // No elements in this subtree
        if (left > right) {
            return null;
        }

        // Last element of postorder is the root
        int rootValue = postorder[postIndex--];

        Node root = new Node(rootValue);

        // Find root position in inorder
        int rootIndex = inorderMap.get(rootValue);

        // Since postorder is processed from right to left,
        // build right subtree first
        root.right = buildTree(inorder, postorder,
                                rootIndex + 1, right);

        // Build left subtree
        root.left = buildTree(inorder, postorder,
                               left, rootIndex - 1);

        return root;
    }

    // Preorder traversal
    static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of nodes
        int N = sc.nextInt();

        int[] inorder = new int[N];
        int[] postorder = new int[N];

        // Read inorder
        for (int i = 0; i < N; i++) {
            inorder[i] = sc.nextInt();
        }

        // Read postorder
        for (int i = 0; i < N; i++) {
            postorder[i] = sc.nextInt();
        }

        // Store inorder indices
        for (int i = 0; i < N; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Start from last element of postorder
        postIndex = N - 1;

        // Construct tree
        Node root = buildTree(inorder, postorder, 0, N - 1);

        // Print preorder
        preorder(root);

        sc.close();
    }
}