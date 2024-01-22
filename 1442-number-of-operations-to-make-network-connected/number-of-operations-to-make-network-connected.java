class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1)
            return -1;
        
        DisjoinSet uf = new DisjoinSet(n);
        for(int i=0;i<connections.length;i++) {

            uf.unionByRank(connections[i][0],connections[i][1]);
            // System.out.print(uf.getNumberOfSets()+" ");
        }
         System.out.println();
        
        int connectionsNeeded = uf.getNumberOfSets()-1;
        return connectionsNeeded;

    }
}

class DisjoinSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    int numberOfSets;
    public DisjoinSet(int n)
    {
        numberOfSets=n;
        for(int i=0;i<n;i++)
        {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node)
    {
        if(parent.get(node)==node)
            return node;

        int ulp=findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    } 

    public void unionByRank(int u,int v)
    {
        int ulp_u=findParent(u);
        int ulp_v=findParent(v);

        if(ulp_u==ulp_v)
            return;
        else if(rank.get(ulp_u) < rank.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
        } 
        else if(rank.get(ulp_v) < rank.get(ulp_u))
        {
            parent.set(ulp_v,ulp_u);
        }
        else
        {
            parent.set(ulp_u, ulp_v);
            rank.set(ulp_v, rank.get(ulp_v) + 1);
        } 
        numberOfSets--;
    }

    public int getNumberOfSets()
    {
        return numberOfSets;
    }
    
}