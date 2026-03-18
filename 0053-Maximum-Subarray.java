class Solution {

    public int maxSubArray(int[] nums) {

        int i = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = Integer.MIN_VALUE;
        
        while(i < nums.length){
            if(currSum == Integer.MIN_VALUE){
                currSum=nums[i++];
            }else{
                currSum+=nums[i++];
            }

            maxSum = Math.max(maxSum, currSum);
            
            //-2+1 = -1
            if(currSum < 0){
                currSum = Integer.MIN_VALUE;
            }

        }

        return maxSum;
    }
}
