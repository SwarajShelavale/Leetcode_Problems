class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> res = new ArrayList<>();
         combinations(0,candidates,target,new ArrayList<>(),res);
        return res;
    }

    void combinations(int start,int candidates[],int target,List<Integer>temp,List<List<Integer>> res )
    {
        if(target==0)
            res.add(new ArrayList<>(temp));
        if(target<0)
            return;

        for(int i=start;i<candidates.length;i++)
        {
            temp.add(candidates[i]);
            combinations(i,candidates,target-candidates[i],temp,res);
            temp.remove(temp.size()-1);
        }
    }
}