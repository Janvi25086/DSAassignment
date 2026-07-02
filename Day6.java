import java.util.Scanner;

class Day6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Print unique elements
        if (n > 0) {
            System.out.print(arr[0] + " ");

            for (int i = 1; i < n; i++) {
                if (arr[i] != arr[i - 1]) {
                    System.out.print(arr[i] + " ");
                }
            }
        }

        sc.close();
    }
}