class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length , m = grid[0].length ;

        UnionFind uf  = new UnionFind(n*m);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    if(i>0 && grid[i-1][j]==1)
                        uf.unionBySize(i*m+j, (i-1)*m+j);
                    
                    if(j>0 && grid[i][j-1]==1)
                        uf.unionBySize(i*m+j, i*m+(j-1));
                    
                }
            }
        }

        int maxArea=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1)
                    maxArea=Math.max(maxArea,uf.size[uf.findParent(i*m+j)]);

        return maxArea;
    }
}



class UnionFind {

    int parent[];
    int size[];

    UnionFind(int len)
    {
        parent  = new int[len];
        size    = new int[len];

        for(int i=0;i<len;i++)
        {
            parent[i]=i;
            size[i] = 1;
        }
    }

    public void unionBySize(int u,int v)
    {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u==ulp_v)
            return;
        
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else 
        {
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
    }

    public int findParent(int u)
    {
         if (parent[u] == u)
            return u;

        return parent[u] = findParent(parent[u]);
    }


}