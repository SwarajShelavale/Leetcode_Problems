class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        Set<List<Integer>> set= new HashSet<>();
        int n=nums.length;

        for(int i=0;i<n-2;i++)
        {
            int j=i+1,k=n-1;
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    continue;
                }
                
                if(nums[j]+nums[k]+nums[i]>0)
                    k--;
                else
                    j++;
            }
        }

        triplets.addAll(set);
        return triplets;
    }
}
