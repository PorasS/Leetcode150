class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length == 1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //[[1,3],[2,6],[8,10],[15,18]]
        int[] curr = intervals[0];//[8,10]
        List<Integer> l = null;
        List<List<Integer>> ll = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            if(curr[1] >= intervals[i][0]){//merge condition
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }else{
                l = Arrays.asList(curr[0], curr[1]);
                ll.add(l);

                curr[0] = intervals[i][0];
                curr[1] = intervals[i][1];
            }
        }
    
        l = Arrays.asList(curr[0], curr[1]);
        ll.add(l);
        
        int[][] res = new int[ll.size()][2];
        int k = 0;
        for(List<Integer> e : ll){
            res[k][0] = e.get(0);
            res[k][1] = e.get(1);
            k++;
        }

        return res;
    }
}
