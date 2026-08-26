import java.util.*;

public class Day61 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of vertices
        int n = sc.nextInt();

        // Number of edges
        int m = sc.nextInt();

        // Ask whether graph is directed
        System.out.print("Enter 1 for Directed, 0 for Undirected: ");
        int type = sc.nextInt();

        // Create adjacency matrix
        int[][] graph = new int[n][n];

        // Read edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            // Edge u -> v
            graph[u][v] = 1;

            // For undirected graph
            if (type == 0) {
                graph[v][u] = 1;
            }
        }

        // Print adjacency matrix
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}