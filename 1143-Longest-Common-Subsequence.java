class Solution {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return compare(text1.toCharArray(), text2.toCharArray(), text1.length() - 1, text2.length() - 1);
    }

    public int compare(char[] chs1, char[] chs2, int idx1, int idx2) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (dp[idx1][idx2] > -1) {
            return dp[idx1][idx2];
        }

        int res = 0;
        if (chs1[idx1] == chs2[idx2]) {
            res = 1 + compare(chs1, chs2, idx1 - 1, idx2 - 1);

            dp[idx1][idx2] = res;

            return dp[idx1][idx2];
        }

        res = 0 + Math.max(compare(chs1, chs2, idx1 - 1, idx2), compare(chs1, chs2, idx1, idx2 - 1));

        dp[idx1][idx2] = res;

        return dp[idx1][idx2];
    }
}
