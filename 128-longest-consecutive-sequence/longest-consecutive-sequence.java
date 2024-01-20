class Solution {
    public int longestConsecutive(int[] nums) {
        int n =nums.length;
        
        if(n<=1)
            return n;
        
        UnionFind uf = new UnionFind(n);
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(nums[i]))
                continue;
            
            mp.put(nums[i],i);

            if(mp.containsKey(nums[i]-1))
                uf.unionByRank(i,mp.get(nums[i]-1));
            
            if(mp.containsKey(nums[i]+1))
                uf.unionByRank(i,mp.get(nums[i]+1));            
        }

        return uf.findMax();
        
    }
}


class UnionFind {
    int parent[];
    int rank[];
    UnionFind(int n)
    {
        parent  = new int[n];
        rank    = new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
    }


    public void unionByRank(int u,int v)
    {
        int ulp_u=findParent(u);
        int ulp_v=findParent(v);

        if(ulp_u==ulp_v)
            return;
        if(rank[ulp_u] < rank[ulp_v])
            parent[ulp_u]=ulp_v;
        else if(rank[ulp_u] > rank[ulp_v])
            parent[ulp_v]=ulp_u;
        else 
        {
            parent[ulp_u]=ulp_v;
            rank[v]++;
        }
    }

    public int findParent(int u)
    {
        if(parent[u]==u)
            return u;

        return parent[u]=findParent(parent[u]);
    }


    public int findMax() {
        int res = 0;
        int count[] = new int[rank.length];
        for(int i=0;i<count.length;i++)
        {
            int r = findParent(i);
            count[r]++;
            res=Math.max(res,count[r]);
        }
        return res;
    }
}