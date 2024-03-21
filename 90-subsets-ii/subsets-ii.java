class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsets(0,nums.length,nums,temp,ls);

        return ls;
    }

    void subsets(int index,int n,int[] nums, List<Integer> temp,List<List<Integer>> ls){
        
        ls.add(new ArrayList<>(temp));
        
        for(int i=index;i<n;i++)
        {
            if(i> index && nums[i] == nums[i-1])
                continue;

            temp.add(nums[i]);
            subsets(i+1,n,nums,temp,ls);
            temp.remove(temp.size()-1);
        }
    }
}