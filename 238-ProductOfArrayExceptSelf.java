class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lp = new int[nums.length];
	    int[] rp = new int[nums.length];

        for(int i = 0; i < lp.length; i++){
            lp[i] = nums[i] * (i-1<0?1:lp[i-1]);
        }

        for(int i = rp.length-1; i>=0; i--){
            rp[i] = nums[i]* (i+1>nums.length-1?1:rp[i+1]);
        }


        for(int i = 0; i<nums.length; i++){
            int l = i-1<0?1:lp[i-1];
            int r = i+1>nums.length-1?1:rp[i+1];
            nums[i] = l*r;
        }

        return nums;
        }
}
