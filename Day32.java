import java.util.Scanner;
import java.util.Stack;

public class Day32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        // Number of elements to push
        int n = sc.nextInt();

        // Push elements
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        // Number of pop operations
        int m = sc.nextInt();

        // Pop elements
        while (m > 0 && !stack.isEmpty()) {
            stack.pop();
            m--;
        }

        // Print remaining stack from top to bottom
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        sc.close();
    }
}