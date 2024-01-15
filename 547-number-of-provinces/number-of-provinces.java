class Solution {
    public int findCircleNum(int[][] isConnected) {
        int N=isConnected.length;
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        // for(int i=0;i<N;i++)
        //     adj.add(new ArrayList<Integer>());
        
        // for(int i=0;i<N;i++)
        // {
        //     for(int j=0;j<N;j++)
        //     {
        //         if(i!=j && isConnected[i][j]==1)
        //         {
        //             adj.get(i).add(j);
        //             adj.get(j).add(i);
        //         }
        //     }
        // }

        int count = 0;
        boolean visited[] =  new boolean[N];

        for(int i=0;i<N;i++)
        {
            if(!visited[i])
            {
                count++;
                // dfs(i,visited,adj);
                dfs(i,visited,isConnected);
            }
        }

        return count;
    }

    // void dfs(int node,boolean visited[] , ArrayList<ArrayList<Integer>> adj )
    // {
    //     visited[node] = true;
    //     for(int x : adj.get(node))
    //     {
    //         if(!visited[x])
    //             dfs(x,visited,adj);
    //     }
    // }

    void dfs(int i,boolean visited[] ,int[][] isConnected)
    {
        visited[i] = true;
        for(int j=0;j<isConnected.length;j++)
        {
            if(i!=j && !visited[j] && isConnected[i][j]==1)
            {
                    dfs(j,visited,isConnected);
            } 
        }
    }
}

// 1 1 0
// 1 1 0
// 0 0 1