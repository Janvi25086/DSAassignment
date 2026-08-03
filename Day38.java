import java.util.*;

public class Day38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        int n = sc.nextInt(); // Number of operations

        for (int i = 0; i < n; i++) {
            String op = sc.next();

            switch (op) {
                case "push_front":
                    deque.addFirst(sc.nextInt());
                    break;

                case "push_back":
                    deque.addLast(sc.nextInt());
                    break;

                case "pop_front":
                    if (!deque.isEmpty())
                        deque.removeFirst();
                    else
                        System.out.println("Deque is Empty");
                    break;

                case "pop_back":
                    if (!deque.isEmpty())
                        deque.removeLast();
                    else
                        System.out.println("Deque is Empty");
                    break;

                case "front":
                    System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;

                case "back":
                    System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
                    break;

                case "size":
                    System.out.println(deque.size());
                    break;

                case "empty":
                    System.out.println(deque.isEmpty());
                    break;

                case "clear":
                    deque.clear();
                    break;

                case "reverse":
                    ArrayList<Integer> list = new ArrayList<>(deque);
                    Collections.reverse(list);
                    deque.clear();
                    deque.addAll(list);
                    break;

                case "sort":
                    list = new ArrayList<>(deque);
                    Collections.sort(list);
                    deque.clear();
                    deque.addAll(list);
                    break;

                case "display":
                    if (deque.isEmpty()) {
                        System.out.println("Deque is Empty");
                    } else {
                        for (int x : deque)
                            System.out.print(x + " ");
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Invalid Operation");
            }
        }

        sc.close();
    }
}