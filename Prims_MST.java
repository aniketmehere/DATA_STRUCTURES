import java.util.*;

class Prims_MST {
    public void prim(int G[][], int v) {
        int mincost = 0;
        int INF = 99999;
        int no_edge;

        boolean[] select = new boolean[v];
        Arrays.fill(select, false);
        no_edge = 0;
        select[0] = true;
        while (no_edge < v - 1) {
            int min = INF;
            int x = 0;
            int y = 0;
            for (int i = 0; i < v; i++) {
                if (select[i] == true) {
                    for (int j = 0; j < v; j++) {
                        if (!select[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.printf("Edge %d (%d , %d) cost %d \n", no_edge++, x, y, G[x][y]);
            select[y] = true;
            mincost += G[x][y];
        }
        System.out.println("min cost :" + mincost);
    }

    public static void main(String[] args) {
        Prims_MST g = new Prims_MST();
        int v = 5;
        int[][] G = { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        g.prim(G, v);
    }
}
