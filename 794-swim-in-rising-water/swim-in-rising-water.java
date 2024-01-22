class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int ans = Math.max(grid[0][0],grid[n-1][n-1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        boolean visited[][] = new boolean[n][n];

        visited[0][0]=true;
        int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};

        pq.add(new int[]{ans,0,0});

        while(!pq.isEmpty())
        {
            int cur[] = pq.poll();
            ans=Math.max(ans,cur[0]);

            for(int i=0;i<4;i++)
            {
                int r = cur[1]+dir[i][0];
                int c = cur[2]+dir[i][1];

                if(r>=0 && c>=0 && r<n && c<n && !visited[r][c])
                {
                    if(r==n-1 && c==n-1)
                        return ans;
                    
                    pq.add(new int[]{grid[r][c],r,c});
                    visited[r][c]=true;
                }
            }
        }

        return ans;
    }
}