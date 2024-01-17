    class Pair {
        int row;
        int col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }

    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            // Using Dijekstra Algorithm (Priority Queue Implementation)
            
            int n=grid.length,m=grid[0].length;
            if(grid[0][0]!=0 || grid[n-1][m-1]!=0)
                return -1;
            
            int[][] dist = new int[][] { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1} };
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(0,0));

            int length=0;
            boolean visited[][] = new boolean[n][m]; 
            while(!q.isEmpty())
            {
                length++;
                int size=q.size();
                for(int i=0;i<size;i++)
                {
                    Pair p = q.poll();

                    if(p.row==n-1 && p.col==m-1)
                        return length;
                    
                    for(int j=0;j<8;j++)
                    {
                        int nRow=p.row+dist[j][0];
                        int nCol=p.col+dist[j][1];
                         if(nRow>=0 && nCol>=0 && nRow<n && nCol<m  && !visited[nRow][nCol] && grid[nRow][nCol]==0 )
                        {
                            q.add(new Pair(nRow,nCol));
                            visited[nRow][nCol]=true;
                        }
                    }                   
                }
            }

            return -1;

        }
    }