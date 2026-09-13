import java.util.*;

class Day79 {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Input edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            // Undirected graph
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int source = sc.nextInt() - 1;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // {distance, vertex}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[source] = 0;
        pq.offer(new int[]{0, source});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int distance = current[0];
            int node = current[1];

            // Ignore outdated entry
            if (distance != dist[node]) {
                continue;
            }

            for (Edge edge : graph.get(node)) {

                int newDistance = distance + edge.weight;

                if (newDistance < dist[edge.to]) {
                    dist[edge.to] = newDistance;
                    pq.offer(new int[]{newDistance, edge.to});
                }
            }
        }

        // Print distances
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("-1");
            } else {
                System.out.print(dist[i]);
            }

            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        sc.close();
    }
}