class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int row = mat.length, col= mat[0].length;
        for(int i=0;i<row;i++)
        {
           //Approach 1: Brute-Force / Naive
            for(int j=0;j<col;j++)
            {                           
                if(i==j)  // TopLeft---> BottomRight
                    sum+= mat[i][j];
                if(j == col-i-1)  // TopRight --> BottomLeft
                    sum+= mat[i][j];
            }  

            //Approach 2: Efficient
            //  sum += (mat[i][i]) + (mat[i][col-i-1]);
        }

        if(row%2==1)
        {
          sum-=mat[row/2][col/2];
        }

        return sum;
    }
}

