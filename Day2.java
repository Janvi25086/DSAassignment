import java.util.Scanner;

class Day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of elements
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Read position to delete (1-based)
        int pos = sc.nextInt();

        // Shift elements to the left
        for (int i = pos - 1; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Print updated array
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}