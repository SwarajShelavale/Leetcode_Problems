class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x:nums)
            arr.add(x);
        
        int n=nums.length;

        k= k%n;

        Collections.reverse(arr.subList(0,n));
        Collections.reverse(arr.subList(0,k));
        Collections.reverse(arr.subList(k,n));

        for(int i=0;i<n;i++)
            nums[i]=arr.get(i);
    }
}