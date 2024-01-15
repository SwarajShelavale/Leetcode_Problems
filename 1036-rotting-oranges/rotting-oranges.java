class Solution {
    public int orangesRotting(int[][] grid) {
        int  m=grid.length,n=grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int rottonOranges=0,FreshOranges=0;
    
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair(i,j));
                    rottonOranges++;
                }
                else if(grid[i][j]==1)
                {
                    FreshOranges++;
                }
            }
        }

        if(FreshOranges==0)
            return 0;
        else if(rottonOranges==0)
            return -1;

        int minutes=0;
        boolean visited[][] = new boolean[m][n];
        int delRow[] = {-1,0,1,0},delCol[]={0,-1,0,1};
        while(!q.isEmpty())
        {
            minutes++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Pair p = q.poll();
                for(int k=0;k<4;k++)
                {
                    int nRow = p.row+delRow[k];
                    int nCol = p.col+delCol[k];

                    if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && !visited[nRow][nCol] && grid[nRow][nCol]==1)
                    {
                        FreshOranges--;
                        visited[nRow][nCol]=true;
                        grid[nRow][nCol]=2;
                        q.add(new Pair(nRow,nCol));
                    }
                }
            }
        }

        if(FreshOranges>0)
            return -1;

        return minutes-1;
    }
}

class Pair {
    int row;
    int col;
    Pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}