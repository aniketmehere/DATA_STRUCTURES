import java.io.*;
import java.util.*;
import java.util.Scanner;

class Linear_Probing {
	private int currentsize, maxsize;
	private String[] keys;
	private String[] vals;

	public Linear_Probing(int capicity) {
		currentsize = 0;
		maxsize = capicity;
		keys = new String[maxsize];
		vals = new String[maxsize];
	}

	public void makeEmpty() {
		currentsize = 0;
		keys = new String[maxsize];
		vals = new String[maxsize];
	}

	public int getSize() {
		return currentsize;
	}

	public boolean isFull() {
		return currentsize == maxsize;
	}

	public boolean isEmpty() {
		return currentsize == 0;
	}

	public boolean contain(String k) {
		return get(k) != null;
	}

	public int hash(String k) {
		return Integer.parseInt(k) % maxsize;
	}

	public void insert(String k, String v) {
		int temp = hash(k);
		int i = temp;
		do {
			if (keys[i] == null) {
				keys[i] = k;
				vals[i] = v;
				currentsize++;
				return;
			}
			if (keys[i].equals(k)) {
				vals[i] = v;
				return;
			}
			i = (i + 1) % maxsize;
		} while (i != temp);
	}

	public String get(String k) {
		int i = hash(k);
		while (keys[i] != null) {
			if (keys[i].equals(k))
				return vals[i];
			i = (i + 1) % maxsize;
		}
		return null;
	}

	public void remove(String k) {
		if (!contain(k))
			return;
		int i = hash(k);
		while (!k.equals(keys[i]))
			i = (i + 1) % maxsize;
		keys[i] = vals[i] = null;
		for (i = (i + 1) % maxsize; keys[i] != null; i = (i + 1) % maxsize) {
			String temp1 = keys[i], temp2 = vals[i];
			keys[i] = vals[i] = null;
			currentsize--;
			insert(temp1, temp2);
		}
		currentsize--;
	}

	public void printHashTable() {
		System.out.println("Hashtable");
		for (int i = 0; i < maxsize; i++) {
			if (keys[i] != null)
				System.out.println(keys[i] + " " + vals[i]);
			System.out.println();
		}
	}
}

public class Linear_Probing1 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hash Table");
		System.out.println("Enter size");
		Linear_Probing h = new Linear_Probing(scan.nextInt());
		char ch;

		do {
			System.out.println("\nHash Table Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. remove");
			System.out.println("3. get");
			System.out.println("4. clear");
			System.out.println("5. size");
			int choice = scan.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter key and value");
					h.insert(scan.next(), scan.next());
					break;

				case 2:
					System.out.println("Enter key");
					h.remove(scan.next());
					break;

				case 3:
					System.out.println("Enter key");
					System.out.println("Value = " + h.get(scan.next()));
					break;

				case 4:
					h.makeEmpty();
					System.out.println("Hash Table Cleared\n");
					break;

				case 5:
					System.out.println("Size = " + h.getSize());
					break;

				default:
					System.out.println("Wrong Entry \n ");
					break;
			}

			h.printHashTable();

			System.out.println("\nDo you want to continue (Type y or n)\n");

			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
