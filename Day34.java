import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    // Push operation
    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation
    int pop() {
        if (top == null) {
            return 0;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    // Check if operator
    boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/");
    }

    // Evaluate postfix expression
    int evaluate(String expr) {
        String[] tokens = expr.split(" ");

        for (String token : tokens) {
            if (!isOperator(token)) {
                push(Integer.parseInt(token));
            } else {
                int b = pop();
                int a = pop();

                switch (token) {
                    case "+":
                        push(a + b);
                        break;
                    case "-":
                        push(a - b);
                        break;
                    case "*":
                        push(a * b);
                        break;
                    case "/":
                        push(a / b);
                        break;
                }
            }
        }

        return pop();
    }
}

public class Day34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        Stack stack = new Stack();
        System.out.println(stack.evaluate(expression));

        sc.close();
    }
}