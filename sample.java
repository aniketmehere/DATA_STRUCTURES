import java.util.*;

public class sample {
    static boolean sam(String expr) {
        Deque<Character> Stack = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            if (x == '{' || x == '[' || x == '(') {
                Stack.push(x);
                continue;
            }
            if (Stack.isEmpty())
                return false;

            char check;
            switch (x) {
                case ')':
                    check = Stack.pop();
                    if (check == '[' || check == '{')
                        return false;
                    break;
                case '}':
                    check = Stack.pop();
                    if (check == '[' || check == '(')
                        return false;
                    break;
                case ']':
                    check = Stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;

            }
        }
        return (Stack.isEmpty());

    }

    public static void main(String[] args) {
        try (Scanner Obj = new Scanner(System.in)) {
            System.out.println("Enter paranthesis :");
            String expr = Obj.nextLine();
            if (sam(expr))
                System.out.println("Balanced...");
            else
                System.out.println("Not Balanced...");
        }
    }
}
