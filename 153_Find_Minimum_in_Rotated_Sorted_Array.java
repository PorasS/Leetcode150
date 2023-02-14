class Solution {
    public int findMin(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.min(nums[0], nums[1]);
        }

        for(int i = 1; i<nums.length; i++){
            if(nums[i-1]>nums[i]){
                return nums[i];
            }
        }

        return nums[0];
    }
}
