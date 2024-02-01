import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n <= 1)
            return n;

        UnionFind uf = new UnionFind(n);
        HashMap<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int currentNum = nums[i];
            if (numIndexMap.containsKey(currentNum))
                continue;

            numIndexMap.put(currentNum, i);

            if (numIndexMap.containsKey(currentNum - 1))
                uf.unionByRank(i, numIndexMap.get(currentNum - 1));

            if (numIndexMap.containsKey(currentNum + 1))
                uf.unionByRank(i, numIndexMap.get(currentNum + 1));
        }

        return uf.findMax();
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public void unionByRank(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV)
            return;
        if (rank[parentU] < rank[parentV])
            parent[parentU] = parentV;
        else if (rank[parentU] > rank[parentV])
            parent[parentV] = parentU;
        else {
            parent[parentU] = parentV;
            rank[v]++;
        }
    }

    public int findParent(int u) {
        if (parent[u] == u)
            return u;

        return parent[u] = findParent(parent[u]);
    }

    public int findMax() {
        int maxCount = 0;
        int[] count = new int[rank.length];

        for (int i = 0; i < count.length; i++) {
            int root = findParent(i);
            count[root]++;
            maxCount = Math.max(maxCount, count[root]);
        }

        return maxCount;
    }
}
