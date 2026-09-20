import java.util.*;

class Day86 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long left = 0;
        long right = n;
        long answer = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            // Use n / mid to avoid overflow
            if (mid == 0 || mid <= n / mid) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}