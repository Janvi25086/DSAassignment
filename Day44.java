import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Day44 {

    // Build tree from level-order traversal
    static Node buildTree(int[] arr, int n) {
        if (n == 0 || arr[0] == -1)
            return null;

        Node root = new Node(arr[0]);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < n) {
            Node curr = queue.removeFirst();

            // Left child
            if (i < n && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                queue.add(curr.left);
            }
            i++;

            // Right child
            if (i < n && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // Inorder Traversal
    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, n);

        inorder(root);
        System.out.println();

        preorder(root);
        System.out.println();

        postorder(root);

        sc.close();
    }
}