import java.util.*;

class Day70 {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void bellmanFord(int n, int m, Edge[] edges, int src) {

        int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[n];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relax all edges n-1 times
        for (int i = 1; i <= n - 1; i++) {

            boolean updated = false;

            for (Edge edge : edges) {

                if (dist[edge.u] != INF &&
                    dist[edge.u] + edge.w < dist[edge.v]) {

                    dist[edge.v] = dist[edge.u] + edge.w;
                    updated = true;
                }
            }

            // Optimization: stop if no distance changed
            if (!updated) {
                break;
            }
        }

        // Check for negative weight cycle
        for (Edge edge : edges) {

            if (dist[edge.u] != INF &&
                dist[edge.u] + edge.w < dist[edge.v]) {

                System.out.println("NEGATIVE CYCLE");
                return;
            }
        }

        // Print shortest distances
        for (int i = 0; i < n; i++) {

            if (dist[i] == INF) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        int src = sc.nextInt();

        bellmanFord(n, m, edges, src);

        sc.close();
    }
}