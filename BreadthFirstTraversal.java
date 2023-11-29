import java.io.*;
import java.util.*;

class BreadthFirstTraversal {
    private int V;
    private LinkedList<Integer> adj[];
    private LinkedList<Integer> queue;

    BreadthFirstTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int n) {

        boolean nodes[] = new boolean[V];
        int a = 0;

        nodes[n] = true;
        queue.add(n);

        while (queue.size() != 0) {
            n = queue.poll();
            System.out.print(n + " ");
            for (int i = 0; i < adj[n].size(); i++) {
                a = adj[n].get(i);
                if (!nodes[a]) {
                    nodes[a] = true;
                    queue.add(a);
                }
            }
        }
    }

    public static void main(String args[]) {
        BreadthFirstTraversal bf = new BreadthFirstTraversal(6);

        bf.addEdge(0, 1);
        bf.addEdge(0, 3);
        bf.addEdge(0, 4);
        bf.addEdge(4, 5);
        bf.addEdge(3, 5);
        bf.addEdge(1, 2);
        bf.addEdge(1, 0);
        bf.addEdge(2, 1);
        bf.addEdge(4, 1);
        bf.addEdge(3, 1);
        bf.addEdge(5, 4);
        bf.addEdge(5, 3);

        System.out.println("The Breadth First Traversal of the graph is as follows :");

        bf.BFS(0);
    }
}