import java.util.*;

public class Day53 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Pair to store node and its horizontal distance
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
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

    // Vertical Order Traversal
    static void verticalOrder(Node root) {

        if (root == null) {
            return;
        }

        // TreeMap automatically sorts horizontal distances
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        java.util.Queue<Pair> queue = new java.util.LinkedList<>();

        // Root has horizontal distance 0
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            Node node = current.node;
            int hd = current.hd;

            // Add node to its vertical column
            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            // Left child: horizontal distance -1
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            // Right child: horizontal distance +1
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        // Print from leftmost to rightmost column
        for (List<Integer> column : map.values()) {

            for (int value : column) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        verticalOrder(root);

        sc.close();
    }
}