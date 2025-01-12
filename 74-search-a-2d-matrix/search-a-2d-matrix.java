class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //Approach 1: Brute Force / Naive
        // for(int[] mat: matrix){
        //     for(int value : mat)
        //     {
        //         if(value == target)
        //         {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //Approach 2: Efficient
        int n = matrix.length , m= matrix[0].length;
        for(int i=0; i< n;i++)
        {
            if( target>= matrix[i][0] && target <=matrix[i][m-1])
            {
                for(int j=0;j<m;j++)
                {
                    if(matrix[i][j]==target)
                        return true;
                }
                return false;
            }
        }
        return false;
    }

}

// target = 23
// 1 3 5 7
// 10 11 16 20
// 23 30 34 60

// 100 * 100

// operations -> 10000

// 100 + 100 = 200