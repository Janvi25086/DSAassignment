import java.util.*;

class Day77 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];

        // Start DFS from node 1
        dfs(1);

        // Check whether every node was visited
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                System.out.println("NOT CONNECTED");
                return;
            }
        }

        System.out.println("CONNECTED");
    }
}