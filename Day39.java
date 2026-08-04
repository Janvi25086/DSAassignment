import java.util.Scanner;

public class Day39 {
    static final int MAX = 1000;
    static int[] heap = new int[MAX];
    static int size = 0;

    // Insert into heap
    static void insert(int value) {
        heap[size] = value;
        int i = size;
        size++;

        // Heapify Up
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[parent] <= heap[i])
                break;

            int temp = heap[parent];
            heap[parent] = heap[i];
            heap[i] = temp;

            i = parent;
        }
    }

    // Peek minimum element
    static void peek() {
        if (size == 0)
            System.out.println(-1);
        else
            System.out.println(heap[0]);
    }

    // Extract minimum element
    static void extractMin() {
        if (size == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(heap[0]);

        heap[0] = heap[size - 1];
        size--;

        // Heapify Down
        int i = 0;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap[left] < heap[smallest])
                smallest = left;

            if (right < size && heap[right] < heap[smallest])
                smallest = right;

            if (smallest == i)
                break;

            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            i = smallest;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String op = sc.next();

            if (op.equals("insert")) {
                int x = sc.nextInt();
                insert(x);
            } else if (op.equals("peek")) {
                peek();
            } else if (op.equals("extractMin")) {
                extractMin();
            }
        }

        sc.close();
    }
}
