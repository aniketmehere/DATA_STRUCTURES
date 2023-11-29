class Stack {
    class Node {
        int data;
        Node next;

        public Node(int x) {
            this.data = x;
            next = null;
        }
    }

    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int x) {
        Node node = new Node(x);

        System.out.println("Inserting Element :" + x);
        node.data = x;
        node.next = top;
        top = node;

    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            System.exit(-1);
        }
        return top.data;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println("Deleting " + top.data);
            top = top.next;
        }
    }

    public void display() {
        if (top == null) {
            System.out.println("The stack is empty");
        } else {
            Node current = top;
            System.out.print("The Elements in the Stack are : ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

    }

}

class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(6);
        stack.push(9);
        stack.push(13);
        stack.push(15);

        stack.display();
        System.out.println("The top of the Stack is : " + stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
        stack.pop();
        stack.display();

    }

}