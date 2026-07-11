import java.util.Scanner;

class Day15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read rows and columns
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        // Read matrix elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int sum = 0;

        // Calculate primary diagonal sum
        for (int i = 0; i < Math.min(m, n); i++) {
            sum += matrix[i][i];
        }

        System.out.println(sum);

        sc.close();
    }
}