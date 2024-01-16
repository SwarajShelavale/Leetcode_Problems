class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        Stack<Integer> st= new Stack<>();
        int topo[] = new int[numCourses];
        boolean visited[] = new boolean[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,adj,visited,topo,st))
                {
                    return new int[]{};
                }
            }
        } 

        int res[] = new int[st.size()];
        int index=st.size()-1;
        while(!st.isEmpty())
        {
            res[index--]=st.pop();
        }
        return res;
    }

    boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean visited[],int topo[],Stack<Integer> st)
    {
        visited[node]=true;
        topo[node]=1;

        for(int x:adj.get(node))
        {
            if(!visited[x])
            {
                if(dfs(x,adj,visited,topo,st))
                    return true;
            }
            else if(topo[x]==1)
                return true;
        }

        st.add(node);
        topo[node]=0;
        return false;
    }
}