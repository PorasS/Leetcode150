class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length == 1){
            int[] res = new int[1];
            res[0]= nums[0];
            return res;
        }
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],0);	
            }
            map.put(nums[i], map.get(nums[i])+1);
        }

        int index = 0;
        int[] result = new int[k];
        
        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());//log n 
        
        Collections.sort(mapList,(i1,i2) -> i2.getValue()-i1.getValue());
        
        for(Map.Entry<Integer, Integer> entry : mapList){
            if(index<k){
                result[index] = entry.getKey();
                index++;
            }
        }

        return result;
    }
}
