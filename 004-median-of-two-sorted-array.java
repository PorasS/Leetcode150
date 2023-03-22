class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    if(nums1.length>=nums2.length){
		  return  getMedian(nums2, nums1);
    }else{
        return getMedian(nums1, nums2);
    }

  }
  
  public double getMedian(int[] nums1, int[] nums2) {
    //adding 1 from handling even and odd conditions
    int half = (nums1.length + nums2.length +1)/ 2;
    int l = 0;
    int r = nums1.length;

    while (l <= r) {
       
        int i = (l + r) / 2;
        int j = half - i;

        int xl = (i==0)?Integer.MIN_VALUE:nums1[i - 1];
        int xr = (i==nums1.length)?Integer.MAX_VALUE:nums1[i];
        
        int yl = (j==0)?Integer.MIN_VALUE:nums2[j - 1];
        int yr = (j==nums2.length)?Integer.MAX_VALUE:nums2[j];
        
        if (xl <= yr && yl <= xr) {
            if ((nums1.length + nums2.length) % 2 == 0) {
                double max = Double.valueOf(Math.max(xl, yl));
                double min = Double.valueOf(Math.min(xr, yr));
                return (max + min)/ 2;
            } else {
                return Double.valueOf(Math.max(xl, yl));
            }
        } else if (yl > xr) {
            l = i+1;
        } else {
            r = i - 1;
        }
    }
    return 0.0;
  }


}
