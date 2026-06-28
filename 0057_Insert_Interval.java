class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            int[][] defaultArray = new int[1][2];
            defaultArray[0][0] = newInterval[0];
            defaultArray[0][1] = newInterval[1];
            return defaultArray;
        }

        List<List<Integer>> res = new ArrayList<>();

        int sn = newInterval[0];
        int en = newInterval[1];

        int i = 0;

        boolean newIntervalAdded = false;

        while (i < intervals.length) {
            int[] interval = new int[2];
            if (sn >= intervals[i][0] && sn <= intervals[i][1] || en >= intervals[i][0] && en <= intervals[i][1] ||
                    sn <= intervals[i][0] && en >= intervals[i][1]) {
                interval[0] = Math.min(sn, intervals[i][0]); //[3,]
                interval[1] = Math.max(en, intervals[i][1]); //[3,8]
                int j = i + 1;
                //merge condition
                while (j < intervals.length && en >= intervals[j][0]) {
                    interval[1] = Math.max(en, intervals[j][1]);
                    j++;
                }
                i = j;
                newIntervalAdded = true;
            } else {
                //default
                interval[0] = intervals[i][0];
                interval[1] = intervals[i][1];
                i++;
            }

            List<Integer> l = new ArrayList<>();
            l.add(interval[0]);
            l.add(interval[1]);
            res.add(l);

        }

        if (!newIntervalAdded) {
            List<Integer> l = new ArrayList<>();
            l.add(sn);
            l.add(en);
            res.add(l);
        }

        int[][] resArray = new int[res.size()][2];

        int p = 0;
        for (List<Integer> ll : res) {
            resArray[p][0] = ll.get(0);
            resArray[p][1] = ll.get(1);
            p++;
        }

        Arrays.sort(resArray, (a, b) -> a[0] - b[0]);

        return resArray;

    }
}
