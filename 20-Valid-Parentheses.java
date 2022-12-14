class Solution {
    public boolean isValid(String s) {

        if(s.length() == 1 || s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')'){
            return false;
        }        
        
        Stack<Character> stack = new Stack<>();
        try{
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                    stack.push(s.charAt(i));
                }else if((s.charAt(i)==')' && stack.peek()=='(') || (s.charAt(i)=='}' && stack.peek()=='{') ||
                    (s.charAt(i)==']' && stack.peek()=='[')){
                        stack.pop();
                    }else{
                    return false;
                }
            }
        }catch(Exception e){
            return false;
        }
        
        return stack.isEmpty() ? true : false;
    }
}
