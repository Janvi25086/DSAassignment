import java.util.*;

class Day78 {

    static class Edge {
        int to, weight;

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

        // Build adjacency list
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // Convert 1-based vertices to 0-based
            u--;
            v--;

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        boolean[] visited = new boolean[n];

        // {weight, vertex}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0});

        int mstWeight = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            int[] current = pq.poll();

            int weight = current[0];
            int node = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            mstWeight += weight;
            count++;

            for (Edge edge : graph.get(node)) {

                if (!visited[edge.to]) {
                    pq.offer(new int[]{edge.weight, edge.to});
                }
            }
        }

        System.out.println(mstWeight);

        sc.close();
    }
}