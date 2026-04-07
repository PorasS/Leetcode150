class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {


        Map<Integer, Boolean> map = new HashMap<>();
        map.put(0, false);
        map.put(1, false);
        map.put(2, false);
        for(int i = 0; i < triplets.length; i++){
            int[] triplet = triplets[i];
            if(target[0] == triplet[0] && target[1] >= triplet[1] &&
            target[2] >= triplet[2] ){
                map.put(0, true);
            }
            if(target[1] == triplet[1] && target[0] >= triplet[0] &&
            target[2] >= triplet[2] ){
                map.put(1, true);
            }
            if(target[2] == triplet[2] && target[0] >= triplet[0] &&
            target[1] >= triplet[1] ){
                map.put(2, true);
            }
        }

        return map.get(0) && map.get(1) && map.get(2);
        
    }
}
