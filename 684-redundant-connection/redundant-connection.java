class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        UnionFind un = new UnionFind(n);


        int redundantIndex=-1;
        for(int i=0;i<n;i++)
        {
            int ulp_u=un.findParent(edges[i][0]);
            int ulp_v=un.findParent(edges[i][1]);

            if(ulp_u==ulp_v)
                redundantIndex=i;
            un.unionByRank(edges[i][0],edges[i][1]);
        }

        return new int[]{edges[redundantIndex][0],edges[redundantIndex][1]};
    }
}


class UnionFind {
    int parent[];
    int rank[];

    UnionFind(int n)
    {
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<=n;i++)
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