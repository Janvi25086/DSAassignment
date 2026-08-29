import java.util.*;

public class Day64 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    // DFS using recursion
    static void dfs(int vertex) {

        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    // BFS using Queue
    static void bfs(int source) {

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {

            int vertex = queue.poll();

            System.out.print(vertex + " ");

            for (int neighbor : graph.get(vertex)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            // Undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Source vertex
        int source = sc.nextInt();

        visited = new boolean[n];

        // BFS
        bfs(source);

        sc.close();
    }
}