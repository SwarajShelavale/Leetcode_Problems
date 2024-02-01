class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;
        int n = grid.length, m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

            for (int[] dir : directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && !visited[nRow][nCol] && grid[nRow][nCol] == '1') {
                    visited[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }
}

  class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
