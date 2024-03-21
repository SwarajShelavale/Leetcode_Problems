class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
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
            if(i > start && candidates[i]==candidates[i-1])
                continue;
            temp.add(candidates[i]);
            combinations(i+1,candidates,target-candidates[i],temp,uniqueCombinations);
            temp.remove(temp.size()-1);
        }
    }
}