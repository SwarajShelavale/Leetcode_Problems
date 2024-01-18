class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int matrix[][] = new int[n][n];

        for (int i =0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                if (i != j) {
                    matrix[i][j] = (int)1e8;
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int row = edges[i][0];
            int col = edges[i][1];
            int weight = edges[i][2];

            matrix[row][col] = weight;
            matrix[col][row] = weight;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != (int)1e8 && matrix[k][j] !=(int)1e8) {
                        matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
                    }
                }
            }
        }

        int minCityCount=Integer.MAX_VALUE;
        int res=-1;
        for(int i=0;i<n;i++)
        {
            int cities=0;
            for(int j=0;j<n;j++)
            {
                if(i!=j && matrix[i][j]!=(int)1e8 && matrix[i][j]<=distanceThreshold)
                    cities++;
            }
            if(cities<=minCityCount)
            {
                minCityCount=cities;
                res=i;
            }
        }

        return res;
    }
}