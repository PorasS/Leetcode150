class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length == 1){
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);

        int maxEnd = intervals[0][1];
        int removeInterval = 0;
        for(int i=1; i < intervals.length; i++){
            if(intervals[i][0] < maxEnd){
                removeInterval++;
            }else{
                maxEnd = Math.max(maxEnd, intervals[i][1]);
            }
        }

        return removeInterval;
    }
}
