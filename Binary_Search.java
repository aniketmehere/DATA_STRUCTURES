import java.io.*;
import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int data) {
        key = data;
        left = right = null;
    }
}

class Binary_Search {
    Node root;

    public Binary_Search() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    public Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }

    boolean search(int key) {
        Node temp = searchRecursive(root, key);
        if (temp != null) {
            return true;
        } else {
            return false;
        }
    }

    public Node searchRecursive(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        } else if (root.key > key) {
            return searchRecursive(root.left, key);
        } else {
            return searchRecursive(root.right, key);
        }
    }

    int minvalue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    int maxvalue(Node root) {
        int max = root.key;
        while (root.right != null) {
            max = root.right.key;
            root = root.right;
        }
        return max;
    }

    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    Node delete_Recursive(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)
            root.right = delete_Recursive(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minvalue(root.right);
            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    public static void main(String[] args) {
        Binary_Search b = new Binary_Search();
        b.insert(40);
        b.insert(20);
        b.insert(30);
        b.insert(60);
        b.insert(50);
        b.insert(10);
        b.deleteKey(20);
        b.inorder(b.root);
        boolean ret_val = b.search(50);
        System.out.println("Key 50 is present:" + ret_val);
        System.out.println("minimum value is " + b.minvalue(b.root));
        System.out.println("maximum value is " + b.maxvalue(b.root));
    }
}
