import java.util.*;

class Day89 {

    // Check if books can be allocated to at most m students
    // with each student getting at most maxPages pages.
    static boolean canAllocate(int[] pages, int m, int maxPages) {

        int students = 1;
        int currentPages = 0;

        for (int page : pages) {

            if (currentPages + page > maxPages) {
                students++;
                currentPages = 0;
            }

            currentPages += page;
        }

        return students <= m;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] pages = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();

            left = Math.max(left, pages[i]);
            right += pages[i];
        }

        // If there are more students than books,
        // every student cannot receive at least one book.
        if (m > n) {
            System.out.println(-1);
            return;
        }

        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canAllocate(pages, m, mid)) {

                // Allocation is possible.
                // Try to reduce the maximum pages.
                answer = mid;
                right = mid - 1;

            } else {

                // Maximum allowed pages are too small.
                left = mid + 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}