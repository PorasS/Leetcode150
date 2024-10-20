class Solution {
    Map<Integer, Integer> map;
    public int rob(int[] nums) {

        if(nums.length  == 1){
            return nums[0];
        }

        map = new HashMap<>();

        int amt1 = robbedMoney(0, nums, nums.length - 1);

        map = new HashMap<>();

        int amt2 = robbedMoney(1, nums, nums.length);

        return Math.max(amt1, amt2) ;
    }

    public int robbedMoney(int idx, int[] nums,int length){

        if(map.containsKey(idx)){
            return map.get(idx);
        }

        if(idx >= length){
            return 0;
        }

        int amt1 = robbedMoney(idx + 2, nums, length) + nums[idx];

        int amt2 = robbedMoney(idx + 1, nums, length);

        int maxAmount =  Math.max(amt1, amt2);

        map.put(idx, maxAmount);

        return maxAmount;
    }
   
}
