class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            
        }
        int n=mp.size();
        int index=0;
        int arr[] = new int[n];
        for(int x:mp.values()) {
            arr[index++]=x;
            System.out.print(x+" ");
        }
        System.out.println();
        Arrays.sort(arr);
        
        int ans=arr[n-1];
        for(int i=n-2;i>=0;i--) {
            if(arr[i]==arr[i+1])
                ans+=arr[i];
            else
                break;
        }
        
        return ans;
        
        
        
    }
}