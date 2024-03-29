class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> Integer.compare(a[0], b[0]));
        int count=1;
        int temp = points[0][1];
        
        for(int i=1;i<points.length;i++)
        {
            if(points[i][0]>temp)
            {
                count++;
                temp=points[i][1];
            }   
            else
            {
                temp=Math.min(temp,points[i][1]);
            }           
        }
        return count;
    }
}