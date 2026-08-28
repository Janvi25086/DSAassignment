import java.util.*;

public class Day63 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    // Recursive DFS
    static void dfs(int vertex) {

        // Mark current vertex as visited
        visited[vertex] = true;

        // Print current vertex
        System.out.print(vertex + " ");

        // Visit all adjacent vertices
        for (int neighbor : graph.get(vertex)) {

            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of vertices
        int n = sc.nextInt();

        // Number of edges
        int m = sc.nextInt();

        // Create adjacency list
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

        // Starting vertex
        int s = sc.nextInt();

        visited = new boolean[n];

        // Perform DFS
        dfs(s);

        sc.close();
    }
}