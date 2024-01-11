class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();

        for(int i=1;i<n;i++)
        {
           int m=triangle.get(i).size();
           for(int j=0;j<m;j++)
           {
               if(j==0)
               {
                   triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
               }
               else if(j<m-1)
               {
                   triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
               }
               else
               {
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
               }
           }
        }
        int minPathSum=Integer.MAX_VALUE;
        for(int j=0;j<triangle.get(n-1).size();j++)
        {
            minPathSum=Math.min(minPathSum,triangle.get(n-1).get(j));
        }
    return minPathSum;
    }
}