class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrackTopDown("", 0, 0, n);
	    return res;
    }
    public void backtrackTopDown(String str, int open, int close, int n){
        if(str.length() == n*2){
            res.add(str);
            return;
        }
        if(open < n){
            backtrackTopDown(str+"(", open+1, close, n);
        }
        if(close < open){
            backtrackTopDown(str+")", open, close+1, n);
        }
    }
}
