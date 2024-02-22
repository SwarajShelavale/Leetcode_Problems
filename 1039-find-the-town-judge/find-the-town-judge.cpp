class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        if(n==1)
            return 1;
        vector<int> out(n+1,0),in(n+1,0);
        for(auto x: trust)
        {   
            ++out[x[0]];
            ++in[x[1]];
        }
        for(int i=0;i<=n;i++)
        {
            if(in[i]==n-1 && out[i]==0) 
                return i;
        }
        return -1;
        
    }
};