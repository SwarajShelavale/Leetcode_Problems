class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length - 1;
        int area = 0;

        while( left < right)
        {
            int length = right - left;
            int width  = Math.min(height[left],height[right]);
            area = Math.max(area,length*width);

            if(height[left]<height[right])
                left++;
            else
                right--;
        }

        return area;
    }
}