class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> uniqueCombinations = new ArrayList<>();
         combinations(0,candidates,target,new ArrayList<>(),uniqueCombinations);
        return uniqueCombinations;
    }

    void combinations(int start,int candidates[],int target,List<Integer>temp,List<List<Integer>> uniqueCombinations )
    {
        if(target==0)
            uniqueCombinations.add(new ArrayList<>(temp));
        if(target<0)
            return;

        for(int i=start;i<candidates.length;i++)
        {
            temp.add(candidates[i]);
            combinations(i,candidates,target-candidates[i],temp,uniqueCombinations);
            temp.remove(temp.size()-1);
        }
    }
}