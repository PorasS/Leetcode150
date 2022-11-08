class Solution {
    public int lengthOfLongestSubstring(String s) {
        //time complexity is O(n)
        //space complexity is O(k), where k is the unique characters
        if(s.isEmpty()){
            return 0;
        }

        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                max=Math.max(max, (i-j)+1);
                i++;
            }else{
                //remove all the characters where j is pointing
                //util we remove the duplicate character from the set
                while(j<i && set.contains(s.charAt(i))){
                    set.remove(s.charAt(j));
                    j++;
                }
            }
        }
        return max;
       }
}
