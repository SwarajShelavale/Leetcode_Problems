class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int x: nums)
            mp.put(x,mp.getOrDefault(x,0)+1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[1],a[1]));

        for(int key : mp.keySet())
            pq.add(new int[]{key,mp.get(key)});
        
        int res[] = new int[k];

        for(int i=0;i<k;i++)
        {
            int ele[] = pq.peek();
            pq.poll();
            res[i]=ele[0];
        }

        return res;
    }
}