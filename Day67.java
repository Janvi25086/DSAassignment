import java.util.*;

public class Day68 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static java.util.Stack<Integer> stack;

    // DFS for Topological Sort
    static void dfs(int node) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }

        // Add node after visiting all neighbors
        stack.push(node);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of vertices
        int n = sc.nextInt();

        // Number of edges
        int m = sc.nextInt();

        graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read directed edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
        }

        visited = new boolean[n];

        stack = new java.util.Stack<>();

        // DFS from every vertex
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(i);
            }
        }

        // Print topological order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        sc.close();
    }
}