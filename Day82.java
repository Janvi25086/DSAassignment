import java.util.*;

class Day82 {

    // Lower Bound:
    // First index where arr[index] >= x
    static int lowerBound(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;
        int ans = arr.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // Upper Bound:
    // First index where arr[index] > x
    static int upperBound(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;
        int ans = arr.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > x) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        int lower = lowerBound(arr, x);
        int upper = upperBound(arr, x);

        System.out.println(lower + " " + upper);

        sc.close();
    }
}