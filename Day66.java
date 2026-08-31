import java.util.*;

public class Day66 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean[] recursionStack;

    // DFS cycle detection
    static boolean dfs(int node) {

        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbor : graph.get(node)) {

            // If neighbor is not visited
            if (!visited[neighbor]) {

                if (dfs(neighbor)) {
                    return true;
                }
            }

            // If neighbor is already in current DFS path
            else if (recursionStack[neighbor]) {
                return true;
            }
        }

        // Remove node from current recursion path
        recursionStack[node] = false;

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();

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
        recursionStack = new boolean[n];

        boolean cycleFound = false;

        // Check all components
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (dfs(i)) {
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