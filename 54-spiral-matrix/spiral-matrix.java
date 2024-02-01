class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      int m=matrix.length,n=matrix[0].length;
      int firstRow=0,lastRow=m-1,firstCol=0,lastCol=n-1;

      List<Integer> spiralOrder = new ArrayList<>();

      while(firstRow<=lastRow && firstCol<=lastCol)
      {
            int i=firstCol;
            while(i<=lastCol)
                spiralOrder.add(matrix[firstRow][i++]);
            firstRow++;

            i=firstRow;
            while(i<=lastRow)
                spiralOrder.add(matrix[i++][lastCol]);
            lastCol--;
            
            if(firstRow<=lastRow) {
                i=lastCol;
                while(i>=firstCol)
                    spiralOrder.add(matrix[lastRow][i--]);
                lastRow--;
            }

            if(firstCol<=lastCol) {
                i=lastRow;
                while(i>=firstRow)
                    spiralOrder.add(matrix[i--][firstCol]);
                firstCol++;
            }
      }
      return spiralOrder;
    }
}