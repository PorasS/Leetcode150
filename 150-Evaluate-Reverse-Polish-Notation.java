class Solution {
    public int evalRPN(String[] tokens) {
        
        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }
        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++){
            if(stack.size() >= 2 && (tokens[i].equals("+") ||
              tokens[i].equals("-") ||
              tokens[i].equals("*") ||
              tokens[i].equals("/"))){
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(tokens[i].equals("+")){
                    res = op1 + op2;
                }else if(tokens[i].equals("-")){
                    res = op1 - op2;
                }else if(tokens[i].equals("*")){
                    res = op1 * op2;
                }else if(tokens[i].equals("/")){
                    res = op1 / op2;
                } 
                stack.push(Integer.toString(res));
                continue;
            }
            stack.push(tokens[i]);
        }
        
        return !stack.isEmpty() ? Integer.parseInt(stack.pop()) : 0;
    }
}
