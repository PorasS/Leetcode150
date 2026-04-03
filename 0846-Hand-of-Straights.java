class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0){
            return false;
        }

        //count the elements and its occurances
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < hand.length; i++){
            if(!map.containsKey(hand[i])){
                map.put(hand[i], 0);
                minHeap.offer(hand[i]);
            }
            map.put(hand[i], map.get(hand[i]) + 1);
        }

        while(!minHeap.isEmpty()){
            int min = minHeap.peek();
            for(int i = 1;  i <= groupSize; i++){
                if(!map.containsKey(min) || map.get(min) == 0){
                    return false;
                }

                if(map.get(min) > 0){
                    map.put(min, map.get(min) - 1);
                }

                if(map.get(min) == 0){
                    minHeap.remove(min);
                }

                min+=1;
            }
        }
       
        return true;
    }
}
