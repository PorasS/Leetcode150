class Solution {
    Map<String, Integer> dp; 
    public int minDistance(String word1, String word2) {
        dp = new HashMap<>();
        return f(word1.length() - 1, word2.length() - 1, word1, word2);
    }

    public int f(int i, int j, String word1, String word2){
        if(i < 0){
            return j + 1;
        }

        if(j < 0){
            return i + 1;
        }

        String cell = i+"*"+j;

        if(dp.containsKey(cell)){
            return dp.get(cell);
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return f(i-1, j-1, word1, word2);
        }
        int min = 1 + Math.min(f(i-1,j-1, word1, word2),Math.min(f(i, j-1, word1, word2), f(i-1, j, word1, word2)));

        dp.put(cell, min);
        return dp.get(cell);
    }
}
