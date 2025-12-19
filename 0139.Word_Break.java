class Solution {

    List<String> wordDict;
    Map<String, Boolean> dp;

    public boolean wordBreak(String s, List<String> wordDict) {

        this.wordDict = wordDict;
        dp = new HashMap<>();

        boolean flag = false;
        for (String w : wordDict) {
            if (find(s, 0, w)) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean find(String s, int idx, String word) {

        if (idx == s.length()) {
            return true;
        }

        if (idx + word.length() > s.length()) {
            return false;
        }

        String key = word + ":" + Integer.valueOf(idx);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (!s.substring(idx, idx + word.length()).equals(word)) {
            dp.put(key, false);
            return false;
        }

        boolean flag = false;
        for (String w : wordDict) {
            if (find(s, idx + word.length(), w)) {
                flag = true;
            }
        }

        dp.put(key, flag);
        return dp.get(key);
    }
}
