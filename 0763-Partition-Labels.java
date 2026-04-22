class Solution {
    public List<Integer> partitionLabels(String s) {

        //Solution 1:

        // List<Integer> res = new ArrayList<>();

        // Map<Character, Integer> map = new HashMap<>();

        // for(char ch : s.toCharArray()){
        //     if(!map.containsKey(ch)){
        //         map.put(ch, 0);
        //     }

        //     map.put(ch, map.get(ch) + 1);
        // }
        
        // Set<Character> set = new HashSet<>();

        // int i = 0;
        // int j = 0;

        // while(j < s.length()){
        //     char ch = s.charAt(j);
        //     if(set.isEmpty()){
        //         set.add(ch);
        //         map.put(ch, map.get(ch) - 1);
        //     }else{
        //         boolean allZeros = true;
        //         for(char c : set){
        //             if(map.get(c) > 0){
        //                 allZeros = false;
        //             }
        //         }

        //         if(allZeros){
        //             int partLen = j-i;
        //             res.add(partLen);
        //             set = new HashSet<>();
        //             i = j;
        //             j--;
        //         }else{
        //             set.add(ch);
        //             map.put(ch, map.get(ch) - 1);
        //         }
        //     }
        //     j++;
        // }

        // res.add(j-i);//handling out of bounds case

        // return res;

        //Solution 2:

        //<character, lastIndex> 
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }

        int idx = 0;
        int end = 0;
        int size = 1;
        List<Integer> res = new ArrayList<>();

        while(idx < s.length()){

            if(map.get(s.charAt(idx)) > end){
                end = map.get(s.charAt(idx));
            }

            if(idx == end){
                //found the window
                res.add(size);
                size = 0;
            }

            idx++;
            size++;
        }

        return res;
    }    
}
