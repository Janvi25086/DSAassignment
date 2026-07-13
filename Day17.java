import java.util.Scanner;

class Day17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read first element and initialize max and min
        arr[0] = sc.nextInt();
        int max = arr[0];
        int min = arr[0];

        // Read remaining elements and update max and min
        for (int i = 1; i < n; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Print result
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        sc.close();
    }
}