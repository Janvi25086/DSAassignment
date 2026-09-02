import java.util.*;

class Day68 {

    public static void topologicalSort(int V, ArrayList<ArrayList<Integer>> graph) {

        int[] indegree = new int[V];

        // Calculate in-degree of every vertex
        for (int u = 0; u < V; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }

        // Add vertices with in-degree 0
        java.util.Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Kahn's Algorithm
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            for (int v : graph.get(u)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // Check for cycle
        if (result.size() != V) {
            System.out.println("Topological sorting not possible (Cycle exists)");
        } else {
            for (int node : result) {
                System.out.print(node + " ");
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed edges
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topologicalSort(V, graph);
    }
}