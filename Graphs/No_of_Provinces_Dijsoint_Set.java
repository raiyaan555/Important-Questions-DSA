package Graphs;

public class No_of_Provinces_Dijsoint_Set {
    public int findCircleNum(int[][] isConnected) {
        Disjoint_Set_Size ds = new Disjoint_Set_Size(isConnected.length);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    ds.findParent(i, j);
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (ds.parent.get(i) == i)
                cnt++;
        }

        return cnt;

    }
}
