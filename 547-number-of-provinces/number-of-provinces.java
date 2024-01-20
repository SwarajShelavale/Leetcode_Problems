class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        UnionFind un = new UnionFind(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && isConnected[i][j]==1)
                {
                    un.unionByRank(i,j);
                }
            }
        }

        return un.unionCount();
    }
}


class UnionFind {
    int parent[];
    int rank[];

    UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
    }

    public void unionByRank(int u,int v)
    {
        int ulp_u=findParent(u);
        int ulp_v=findParent(v);

        if(ulp_u == ulp_v)
            return;
        
        if(rank[ulp_u]<rank[ulp_v])
            parent[ulp_u]=ulp_v;
        else if(rank[ulp_v]<rank[ulp_u])
            parent[ulp_v]=ulp_u;
        else if(rank[ulp_v]==rank[ulp_u]) {
            parent[ulp_v]=ulp_u;
            rank[ulp_u]++;
        }        
    }

    public int findParent(int u)
    {
        if(parent[u]==u)
            return u;

        return parent[u]=findParent(parent[u]);
    }

    public int unionCount()
    {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            hs.add(findParent(i));
        }

        return hs.size();
    }

}