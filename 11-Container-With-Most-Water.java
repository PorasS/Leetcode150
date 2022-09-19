class Solution {
    public int maxArea(int[] height) {
        
        int maxArea = Integer.MIN_VALUE;

        int i = 0;
        int j = height.length-1;

        while(i<j){
            
            int currentArea = Math.min(height[i],height[j])*(j-i);
   
            if(currentArea>maxArea){
                maxArea = currentArea;
            }

            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }

        }

        return maxArea;

    }
}
