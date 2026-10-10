//https://neetcode.io/problems/meeting-schedule-ii/question

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
    public int minMeetingRooms(List<Interval> intervals) {

        if(intervals.size() == 0 ){
            return 0;
        }

        if(intervals.size() == 1){
            return 1;
        }

        //Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        // Map<Integer, Interval> intervalMap = new HashMap<>();

        // int rooms = 0;
        // boolean existingRoom = false;
        // int currRoom = 0;
        // for(Interval inter : intervals){
        //     if(intervalMap.isEmpty()){
        //         rooms+=1;
        //         intervalMap.put(rooms, inter);
        //     }else{
        //         outer: 
        //         for(Map.Entry<Integer, Interval> e : intervalMap.entrySet()){
        //             Interval currInterval = e.getValue();
        //             currRoom = e.getKey();

        //             if(inter.start >= currInterval.end){
        //                 existingRoom = true;
        //                 break outer;
        //             }
        //         }

        //         if(existingRoom){
        //             intervalMap.put(currRoom, inter);
        //         }else{
        //             intervalMap.put(intervalMap.size()+1, inter);
        //         }

        //         existingRoom = false;
        //     }
        // }

        // return intervalMap.size();

        // Solution 2:
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int k = 0;
        for(Interval inter : intervals){
            start[k] = inter.start;
            end[k] = inter.end;
            k++;
        }

        Arrays.sort(start);
    
        Arrays.sort(end);
        
        int i = 0;
        int j = 0;
        int room = 0;
        int maxRoom = 0;
        while(i < start.length){
            if(start[i] < end[j]){
                //meeting start before current meeting
                //need a seperate room
                room+=1;
                i++;
            }else{
                room-=1;
                j++;
            }
            maxRoom = Math.max(room, maxRoom);
        }

        return maxRoom;
    }
}


