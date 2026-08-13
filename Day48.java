import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Day48 {

    // Build Binary Tree from Level Order (-1 represents NULL)
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

    // Count Leaf Nodes
    static int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, n);

        System.out.println(countLeaves(root));

        sc.close();
    }
}