import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Day46 {

    // Build tree from level order input (-1 represents NULL)
    static Node buildTree(int[] arr, int n) {
        if (n == 0 || arr[0] == -1)
            return null;

        Node root = new Node(arr[0]);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < n) {
            Node curr = queue.removeFirst();

            if (i < n && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                queue.add(curr.left);
            }
            i++;

            if (i < n && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // Level Order Traversal
    static void levelOrder(Node root) {
        if (root == null)
            return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.removeFirst();
            System.out.print(curr.data + " ");

            if (curr.left != null)
                queue.add(curr.left);

            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, n);
        levelOrder(root);

        sc.close();
    }
}
