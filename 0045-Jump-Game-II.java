//Solution 1 : Using Dynamic Programming 
class Solution {
    Map<Integer, Integer> dp;
    public int jump(int[] nums) {
        dp = new HashMap<>();
        int res = minJump(0, nums);
        return  res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minJump(int idx, int nums[]){

        if(dp.containsKey(idx)){
            return dp.get(idx);
        }

        if(idx == nums.length - 1){
            return 0;
        }

        if(idx > nums.length - 1 || nums[idx] == 0){
            return Integer.MAX_VALUE;
        }

        int res = Integer.MAX_VALUE;
   
        for(int i = nums[idx]; i >= 1; i--){
            int minJump = minJump(idx+i, nums);
            if(minJump != Integer.MAX_VALUE){
                res = Math.min(res, minJump);
            }
        }

        res = (res == Integer.MAX_VALUE) ? Integer.MAX_VALUE : 1 + res;
        dp.put(idx, res);
        return dp.get(idx);
    }
}

//------------------------------------------------------
//Solution 2 : Using Range
class Solution {
    public int jump(int[] nums) {

        int l = 0;
        int r = 0;
        int jumps = 0;
        int maxJump = 0;
        while(r < nums.length - 1){
            int maxRange = 0;
            for(int i = l; i <= r; i++){ //calculate the maxRange from between l -> r
                maxRange = Math.max(maxRange, (i+nums[i]));
            }

            l = r+1;
            r = maxRange;
            jumps+=1;
        }

        return jumps;   
    }
}
