import java.util.Scanner;

public class Day37 {
    static final int MAX = 100;
    static int[] pq = new int[MAX];
    static int size = 0;

    // Insert element
    static void insert(int value) {
        int i = size - 1;

        // Shift larger elements to the right
        while (i >= 0 && pq[i] > value) {
            pq[i + 1] = pq[i];
            i--;
        }

        pq[i + 1] = value;
        size++;
    }

    // Delete highest priority (smallest element)
    static void delete() {
        if (size == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(pq[0]);

        for (int i = 1; i < size; i++) {
            pq[i - 1] = pq[i];
        }

        size--;
    }

    // Peek highest priority
    static void peek() {
        if (size == 0) {
            System.out.println(-1);
        } else {
            System.out.println(pq[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String op = sc.next();

            if (op.equals("insert")) {
                int value = sc.nextInt();
                insert(value);
            } else if (op.equals("delete")) {
                delete();
            } else if (op.equals("peek")) {
                peek();
            }
        }

        sc.close();
    }
}