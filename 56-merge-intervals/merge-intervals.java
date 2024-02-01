class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            int size=mergedIntervals.size();
            if(mergedIntervals.isEmpty() || mergedIntervals.get(size-1)[1] < intervals[i][0])
                mergedIntervals.add(intervals[i]);
            else
                mergedIntervals.get(size-1)[1]=Math.max(mergedIntervals.get(size-1)[1],intervals[i][1]);
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}