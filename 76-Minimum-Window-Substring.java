class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()){
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);
        }

        int l = 0;
        int r = 0;
        int count = t.length();
        int minLen = s.length();
        int startIdx = -1;
        while(r < s.length()){

            char c = s.charAt(r++);
            if(map.containsKey(c)){
                if(map.get(c) > 0){
                    count-=1;
                }

                map.put(c, map.get(c) - 1);
            }

            if(count > 0){
                continue;
            }

            while(count == 0){
                if((r-l) <= minLen){
                    minLen = Math.min(minLen, (r-l));
                    startIdx = l;
                }

                char lc = s.charAt(l++);
                if(map.containsKey(lc)){
                    map.put(lc, map.get(lc) + 1);
                    if(map.get(lc) > 0){
                        count+=1;
                    }
                }
            }
        }
        
        return startIdx == -1 ? "" : s.substring(startIdx, (startIdx+minLen));
       
    }
}
