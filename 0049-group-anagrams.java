class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i<strs.length; i++){
            String sortedString = sortedString(strs[i]);
            List<String> list;
            if(map.containsKey(sortedString)){
                list = map.get(sortedString);
            }else{
                list = new ArrayList<>();
            }
            list.add(strs[i]);
            map.put(sortedString, list);
        }

        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<String, List<String>> e : map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }

    public String sortedString(String s){
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
