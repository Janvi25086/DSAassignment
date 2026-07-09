import java.util.Scanner;

class Day13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read rows and columns
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        // Read matrix elements
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;

        // Spiral Traversal
        while (top <= bottom && left <= right) {

            // Traverse top row
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }

        sc.close();
    }
}