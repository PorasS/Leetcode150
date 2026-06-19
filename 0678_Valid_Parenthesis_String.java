class Solution {
    Map<String, Boolean> dp;
    public boolean checkValidString(String s) {
        dp = new HashMap<>();
        return helper2(0, 0, 0, s);
    }

    public boolean helper2(int i, int close, int open, String s){

        String cell = i+"*"+close+"*"+open;

        if(dp.containsKey(cell)){
            return dp.get(cell);
        }

        if(close > open){
            return false;
        }

        // System.out.println(i);
        if(i > s.length()){
            // System.out.println("1: "+i);
            return false;
        }

        if(i == s.length()){
            // System.out.println("2: "+i);
            return close == open;
        }

        boolean starCase = false;
        boolean normalCase = false;
        if(s.charAt(i) == '*'){
            //empty
            starCase = helper2(i+1, close, open, s) || helper2(i+1, close+1, open, s) ||
            helper2(i+1, close, open+1, s);
        }else{
            if(s.charAt(i) == '('){
                open++;
            }
            if(s.charAt(i) == ')'){
                close++;
            }

            normalCase =  helper2(i+1, close, open, s);
        }

        boolean res = normalCase || starCase;

        dp.put(cell, res);

        return dp.get(cell);
        
    }
}
