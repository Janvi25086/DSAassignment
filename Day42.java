import java.util.Scanner;

public class Day42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

        sc.close();
    }
}