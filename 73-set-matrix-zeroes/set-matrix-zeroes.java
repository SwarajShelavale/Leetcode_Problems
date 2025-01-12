class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
        boolean rows[] = new boolean[n];   //{true,false,false}
        boolean cols[] = new boolean[m];   //{true,false,false,true}

        // Check all zero occurances
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    rows[i]=true;
                    cols[j]=true;
                }
            }
        }

        // Update rows and cols on basis of zeroes

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(rows[i] || cols[j])
                {
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}



// 0 0 0 0
// 3 4 5 2
// 1 2 1 5

// 0 --> 0,0
// 1     0,1
// 2     0,2
// 0     0,3

// 3  --> 1,0
// 4  --> 1,1