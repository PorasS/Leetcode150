class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int idx = i+1;
                int j = nums.length-1;

                while(idx<j){
                    List<Integer> list = new ArrayList<>();
                    if(nums[i]+nums[idx]+nums[j]==0){
                        list.add(nums[i]);
                        list.add(nums[idx]);
                        list.add(nums[j]);
                        res.add(list);
                    }

                    if(nums[i]+nums[idx]+nums[j]>0){
                            j--;
                    }else{
                            idx++;
                    }
                }
            }
        }
      return new ArrayList<>(res);   
    }
}
