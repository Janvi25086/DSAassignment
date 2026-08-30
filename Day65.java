import java.util.*;

public class Day65 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    // DFS with parent tracking
    static boolean dfs(int node, int parent) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            // If neighbor is not visited, continue DFS
            if (!visited[neighbor]) {

                if (dfs(neighbor, node)) {
                    return true;
                }
            }

            // If visited neighbor is not the parent,
            // then a cycle exists
            else if (neighbor != parent) {
                return true;
            }
        }

        return false;
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

        // Read edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            // Undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n];

        boolean cycleFound = false;

        // Check every component
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (dfs(i, -1)) {
                    cycleFound = true;
                    break;
                }
            }
        }

        if (cycleFound) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}