
import java.util.*;

class Priority_Queue {
    static int[] H = new int[50];
    static int size = -1;

    static int parent(int i) {
        return (i - 1) / 2;
    }

    static int leftchild(int i) {
        return ((2 * i) + 1);
    }

    static int rightchild(int i) {
        return ((2 * i) + 2);
    }

    static void shiftUp(int i) {
        while (i > 0 && H[parent(i)] < H[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    static void shiftDown(int i) {
        int maxIndex = i;
        int l = leftchild(i);
        if (l <= size && H[l] > H[maxIndex]) {
            maxIndex = l;
        }
        int r = rightchild(i);
        if (r <= size && H[r] > H[maxIndex]) {
            maxIndex = r;
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            shiftDown(maxIndex);
        }
    }

    static void insert(int p) {
        size = size + 1;
        H[size] = p;
        shiftUp(size);
    }

    static int extractMax() {
        int result = H[0];
        H[0] = H[size];
        size = size - 1;
        shiftDown(0);
        return result;
    }

    static void changePriority(int i, int p) {
        int oldp = H[i];
        H[i] = p;
        if (p > oldp) {
            shiftUp(i);
        } else {
            shiftDown(i);
        }
    }

    static int getMax() {
        return H[0];
    }

    static void remove(int i) {
        H[i] = getMax() + 1;
        shiftUp(i);
        extractMax();
    }

    static void swap(int i, int j) {
        int temp = H[i];
        H[i] = H[j];
        H[j] = temp;
    }

    public static void main(String args[]) {
        insert(45);
        insert(20);
        insert(14);
        insert(12);
        insert(31);
        insert(7);
        insert(11);
        insert(13);
        insert(7);
        int i = 0;
        System.out.println("Priority Queue:");
        while (i <= size - 1) {
            System.out.println(H[i] + " ");
            i++;
        }
        System.out.println("\n");
        System.out.println("Node with maximum priority:" + extractMax() + "\n");
        System.out.println("Priority queue after extracting maximum:");
        int j = 0;
        while (j <= size) {
            System.out.println(H[j] + " ");
            j++;
        }
        System.out.println("\n");
        changePriority(2, 49);
        System.out.println("Priority queue after priority change:");
        int k = 0;
        while (k <= size) {
            System.out.println(H[k] + " ");
            k++;
        }
        System.out.println("\n");
        remove(3);
        System.out.println("Priority queue after removing the elements:");
        int l = 0;
        while (l <= size) {
            System.out.println(H[l] + " ");
            l++;
        }
    }
}