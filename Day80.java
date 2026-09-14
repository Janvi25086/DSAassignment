import java.util.*;

class Day80 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dist = new int[n][n];

        // Read adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // No path from i to k or k to j
                    if (dist[i][k] == -1 || dist[k][j] == -1) {
                        continue;
                    }

                    int newDistance = dist[i][k] + dist[k][j];

                    if (dist[i][j] == -1 || newDistance < dist[i][j]) {
                        dist[i][j] = newDistance;
                    }
                }
            }
        }

        // Print shortest distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j]);

                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
