import java.util.*;

class Day84 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Insertion Sort
        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            // Move larger elements one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Put key in its correct position
            arr[j + 1] = key;
        }

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);

            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        sc.close();
    }
}
