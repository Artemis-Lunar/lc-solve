public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 1) {
                count++;
                dfs(isConnected, i);
            }
        }

        return count;
    }

    public void dfs(int[][] isConnected, int city) {
        isConnected[city][city] = 0;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && isConnected[j][j] == 1) {
                dfs(isConnected, j);
            }
        }
    }
}