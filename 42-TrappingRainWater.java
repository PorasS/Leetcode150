class Solution {
    public int trap(int[] height) {
        
        //[4,2,0,6,2,3,5]
        int maxLeft = height[0]; //4
        int maxRight = height[height.length-1]; //5

        int left = 1; //2
        int right = height.length-2; //2

        int amount = 0;
        while(left<=right){
            if(maxLeft<maxRight){
                if(height[left]>maxLeft){
                    maxLeft=height[left];
                }else{
                    amount+=Math.min(maxLeft,maxRight)-height[left];
                }
                left++;
            }else{
                if(height[right]>maxRight){
                    maxRight = height[right];
                }else{
                    amount+=Math.min(maxLeft,maxRight)-height[right];
                }
                right--;
            }
        }
        return amount;
    }
}
