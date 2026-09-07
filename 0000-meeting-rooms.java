/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.isEmpty() || intervals.size() == 1){
            return true;
        }

        //sort the intervals based on startTime
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
    
        Interval interval = intervals.get(0);
        int maxEnd = interval.end;
        int start = interval.start;

        for(int i = 1;  i < intervals.size(); i++){
            interval = intervals.get(i);
            if(interval.start >= maxEnd){
                maxEnd = interval.end;
            }else{
                return false;
            }
        }

        return true;
    }
}
