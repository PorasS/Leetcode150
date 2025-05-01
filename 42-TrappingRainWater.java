class Solution {
  public int trap(int[] height) {

    class Solution {
      public int trap(int[] height) {

        //approach 1:
        //create an array of prefixMax, suffixMax
        //total+=min(prefixMax[i], suffixMax[i]) - height[i]

        // int[] prefixMax = new int[height.length];
        // int[] suffixMax = new int[height.length];

        // for(int i = 0; i < prefixMax.length; i++){
        //     prefixMax[i] = i-1 < 0 ? height[i] : Math.max(prefixMax[i-1], height[i]);
        // }

        // for(int i = height.length - 1; i >= 0; i--){
        //     suffixMax[i] = i+1 > height.length - 1 ? height[i] : Math.max(suffixMax[i+1], height[i]);
        // }

        // int total = 0;
        // for(int i = 0; i < height.length; i++){
        //     if(height[i] < prefixMax[i] && height[i] < suffixMax[i]){
        //         total+= Math.min(prefixMax[i], suffixMax[i]) - height[i];
        //     }
        // }

        // return total;

        //approach 2 : two pointer

        //maxLeft, maxRight
        int l = 0;
        int r = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        int total = 0;

        //[0,1,0,2,1,0,1,3,2,1,2,1]
        //               l r
        //ml = 3 
        //mr = 2
        //tot = 1+1+2+1+1

        while (l < r) {
          maxLeft = Math.max(maxLeft, height[l]);
          maxRight = Math.max(maxRight, height[r]);

          if (height[l] < maxLeft && height[l] < maxRight) {
            total += Math.min(maxLeft, maxRight) - height[l];
          } else if (height[r] < maxLeft && height[r] < maxRight) {
            total += Math.min(maxLeft, maxRight) - height[r];
          }

          if (height[l] <= height[r]) {
            l++;
          } else {
            r--;
          }

        }

        return total;

      }
    }
  }
}
