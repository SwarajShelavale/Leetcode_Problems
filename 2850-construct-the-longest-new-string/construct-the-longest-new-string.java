class Solution {
    public int longestString(int x, int y, int z) {
        if(x==y)
            return (x+y+z)*2;
        else if(x>y)
            return (y+y+z+1)*2;
        else
            return (x+x+z+1)*2;

    }
}
