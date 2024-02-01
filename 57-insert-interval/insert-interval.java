class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int n=intervals.length,i=0;

        //Add Non overlapping intervals before  new Interval
        while(i<n && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }
        
        //Merge overallaping intervals to new Interval then add in res
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval);

        //Add remaining Non overlapping intervals
        while(i<n) {
            mergedIntervals.add(intervals[i]);
            i++;
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
