class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] mat: matrix){
            for(int value : mat)
            {
                if(value == target)
                {
                    return true;
                }
            }
        }
        return false;
    }
}