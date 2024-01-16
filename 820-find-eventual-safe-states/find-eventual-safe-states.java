class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int inDegree[]=new int[n];
        List<Integer> safeNodes = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i); 
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(inDegree[i]==0)
                q.add(i);


        while(!q.isEmpty())
        {
            int node=q.poll();
            safeNodes.add(node);

            for(int x: adj.get(node))
            {
                inDegree[x]--;
                if(inDegree[x]==0)
                    q.add(x);
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;

    }
}