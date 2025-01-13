class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        int n= image.length , m = image[0].length;
        int flippedImage[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            int index=m-1; // use to set value from last to start
            for(int j=0;j<m;j++)
            {
                flippedImage[i][index]=(image[i][j]==1) ? 0:1;
                index--;
            }
        }
        return flippedImage;
    }
}

// flippedImage[i][index]=(image[i][j]==1) ? 0:1;
//Set 1st col to last col then.. if it's flipped
// 0 --> 1
// 1 --> 0