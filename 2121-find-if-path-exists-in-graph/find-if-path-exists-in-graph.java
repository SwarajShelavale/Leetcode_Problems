class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind un = new UnionFind(n);

        for(int i=0;i<edges.length;i++)
        {
            un.unionByRank(edges[i][0],edges[i][1]);
        }

        return un.findParent(source)==un.findParent(destination);
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

}