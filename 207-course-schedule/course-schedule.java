class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        int topo[] = new int[numCourses];
        boolean visited[] = new boolean[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,adj,visited,topo))
                    return false;
            }
        } 

        return true;
    }

    boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean visited[],int topo[] )
    {
        visited[node]=true;
        topo[node]=1;

        for(int x:adj.get(node))
        {
            if(!visited[x])
            {
                if(dfs(x,adj,visited,topo))
                    return true;
            }
            else if(topo[x]==1)
                return true;
        }

        topo[node]=0;
        return false;
    }
}