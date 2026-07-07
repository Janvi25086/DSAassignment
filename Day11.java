import java.util.Scanner;

class Day11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read rows and columns
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] a = new int[m][n];
        int[][] b = new int[m][n];
        int[][] sum = new int[m][n];

        // Read first matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        // Read second matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        // Add the matrices
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        // Print the resultant matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}