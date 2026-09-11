import java.util.*;

public class Day69 {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State implements Comparable<State> {
        int node;
        long distance;

        State(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.distance, other.distance);
        }
    }

    public static long[] dijkstra(
            int n,
            List<List<Edge>> graph,
            int source
    ) {
        long[] distances = new long[n];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<State> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new State(source, 0));

        while (!priorityQueue.isEmpty()) {
            State current = priorityQueue.poll();
            int currentNode = current.node;
            long currentDistance = current.distance;

            // Ignore outdated priority-queue entries.
            if (currentDistance != distances[currentNode]) {
                continue;
            }

            for (Edge edge : graph.get(currentNode)) {
                int nextNode = edge.to;
                long newDistance = currentDistance + edge.weight;

                if (newDistance < distances[nextNode]) {
                    distances[nextNode] = newDistance;
                    priorityQueue.offer(new State(nextNode, newDistance));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int n = 5;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed edges: from -> to with weight
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        int source = 0;
        long[] distances = dijkstra(n, graph, source);

        for (int node = 0; node < n; node++) {
            if (distances[node] == Long.MAX_VALUE) {
                System.out.println("Distance from " + source + " to " + node + " = unreachable");
            } else {
                System.out.println(
                    "Distance from " + source + " to " + node + " = " + distances[node]
                );
            }
        }
    }
}
