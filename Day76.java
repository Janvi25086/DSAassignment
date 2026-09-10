import java.util.*;

class Day76 {
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

        int components = 0;

        // Check every node
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i);
            }
        }

        System.out.println(components);
    }
}