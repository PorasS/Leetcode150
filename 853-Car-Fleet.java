class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        Stack<Float> stack = new Stack<>();
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for(int i = 0; i<position.length; i++){
            map.put(position[i], speed[i]);
        }
    
        for(Integer key : map.keySet()){
            float time = (float)(target-key)/(float)map.get(key);
            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }
        }
        
        return stack.size();
    }
}
