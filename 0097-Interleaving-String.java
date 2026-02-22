class Solution {

    Map<String, Boolean> dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        int totalLength = s1.length() + s2.length();
        if (totalLength != s3.length()) {
            return false;
        }

        dp = new HashMap<>();

        return checkStr(0, 0, 0, s1, s2, s3);
    }

    public boolean checkStr(int idx, int s1Idx, int s2Idx, String str1, String str2, String s3) {

        String cell = s1Idx + "*" + s2Idx + "*" + idx;

        if (dp.containsKey(cell)) {
            return dp.get(cell);
        }

        if (s1Idx >= str1.length() && s2Idx >= str2.length()) {
            dp.put(cell, true);
            return dp.get(cell);
        }

        if (s1Idx >= str1.length()) {
            boolean res1 = s2Idx < str2.length() && str2.charAt(s2Idx) == s3.charAt(idx)
                    ? checkStr(idx + 1, s1Idx, s2Idx + 1, str1, str2, s3)
                    : false;
            dp.put(cell, res1);

            return dp.get(cell);
        }

        if (s2Idx >= str2.length()) {
            boolean res2 = s1Idx < str1.length() && str1.charAt(s1Idx) == s3.charAt(idx)
                    ? checkStr(idx + 1, s1Idx + 1, s2Idx, str1, str2, s3)
                    : false;
            dp.put(cell, res2);

            return dp.get(cell);
        }

        boolean s1Match = false;
        if (s1Idx < str1.length() && str1.charAt(s1Idx) == s3.charAt(idx)) {
            s1Match = checkStr(idx + 1, s1Idx + 1, s2Idx, str1, str2, s3);
        }

        boolean s2Match = false;
        if (s2Idx < str2.length() && str2.charAt(s2Idx) == s3.charAt(idx)) {
            s2Match = checkStr(idx + 1, s1Idx, s2Idx + 1, str1, str2, s3);
        }

        boolean res = s1Match || s2Match;
        dp.put(cell, res);

        return dp.get(cell);
    }
}
