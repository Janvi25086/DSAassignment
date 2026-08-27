import java.util.*;

public class Day62 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of vertices
        int n = sc.nextInt();

        // Number of edges
        int m = sc.nextInt();

        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            // For undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Print adjacency lists
        for (int i = 0; i < n; i++) {

            System.out.print(i + ": ");

            for (int vertex : graph.get(i)) {
                System.out.print(vertex + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}