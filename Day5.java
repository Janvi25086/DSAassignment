import java.util.Scanner;

class Day5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of first array
        int p = sc.nextInt();
        int[] arr1 = new int[p];

        // Read first sorted array
        for (int i = 0; i < p; i++) {
            arr1[i] = sc.nextInt();
        }

        // Read size of second array
        int q = sc.nextInt();
        int[] arr2 = new int[q];

        // Read second sorted array
        for (int i = 0; i < q; i++) {
            arr2[i] = sc.nextInt();
        }

        int i = 0, j = 0;

        // Merge the arrays
        while (i < p && j < q) {
            if (arr1[i] <= arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            } else {
                System.out.print(arr2[j] + " ");
                j++;
            }
        }

        // Print remaining elements of first array
        while (i < p) {
            System.out.print(arr1[i] + " ");
            i++;
        }

        // Print remaining elements of second array
        while (j < q) {
            System.out.print(arr2[j] + " ");
            j++;
        }

        sc.close();
    }
}