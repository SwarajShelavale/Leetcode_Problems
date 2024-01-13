class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        HashMap<Integer,Integer> dp = new HashMap<>();
        int maxLength=0;
        for(int i=0;i<arr.length;i++)
        {
             
            dp.put(arr[i],dp.getOrDefault(arr[i]-difference,0)+1);
            maxLength=Math.max(maxLength,dp.get(arr[i]));
        }

        return maxLength;
        
    }

}
