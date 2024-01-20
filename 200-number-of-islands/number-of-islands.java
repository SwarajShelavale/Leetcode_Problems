class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length , m = grid[0].length ;

        UnionFind uf  = new UnionFind(n*m);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    if(i>0 && grid[i-1][j]=='1')
                        uf.unionByRank(i*m+j, (i-1)*m+j);
                    
                    if(j>0 && grid[i][j-1]=='1')
                        uf.unionByRank(i*m+j, i*m+(j-1));
                    
                }
            }
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                    hs.add(uf.findParent(i*m+j));
            }
        }

        return hs.size();

    }
}


class UnionFind {

    int parent[];
    int rank[];

    UnionFind(int size)
    {
        parent  = new int[size];
        rank    = new int[size];

        for(int i=0;i<size;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
    }

    public void unionByRank(int u,int v)
    {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u==ulp_v)
            return;
        
        if(rank[ulp_u] < rank[ulp_v])
            parent[ulp_u]=ulp_v;
        else if(rank[ulp_v] < rank[ulp_u])
            parent[ulp_v]=ulp_u;
        else 
        {
            parent[ulp_v]=ulp_u;
            rank[ulp_u]++;
        }
    }

    public int findParent(int u)
    {
        if(parent[u]==u)
            return u;
        
        return parent[u] = findParent(parent[u]);
    }


}