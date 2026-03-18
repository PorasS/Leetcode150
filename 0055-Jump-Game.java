class Solution {
    public boolean canJump(int[] nums) {
        
        int maxIdx = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i > maxIdx) return false;
            maxIdx = Math.max(maxIdx, (nums[i] + i));
        }

        return true;
    }
}
