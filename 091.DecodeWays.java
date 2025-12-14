class Solution {
    int[] dp;

    public int numDecodings(String s) {

        if (s.length() == 1 && s.charAt(0) == '0') {
            return 0;
        }
        dp = new int[s.length()];

        return decode(s.toCharArray(), 0);

    }

    public int decode(char[] chs, int idx) {

        if (idx > chs.length - 1) {
            return 1;
        }

        if (dp[idx] > 0) {
            return dp[idx];
        }

        if (chs[idx] == '0') {
            return 0;
        }

        int s = decode(chs, idx + 1);

        int d = 0;
        if (idx + 1 <= chs.length - 1) {
            String ss = String.valueOf(chs[idx]) + String.valueOf(chs[idx + 1]);

            int num = Integer.parseInt(ss);
            if (num < 27) {
                d = decode(chs, idx + 2);
            }
        }
        dp[idx] = s + d;
        return dp[idx];
    }
}
