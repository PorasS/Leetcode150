class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int len = s1.length();
        int i = 0;
        int j = len-1;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for(int i2=97; i2<123; i2++){
            s1Map.put((char)i2,0);
            s2Map.put((char)i2,0);
        }

        for(int i1=0; i1<s1.length();i1++){
            char ch = s1.charAt(i1);
            s1Map.put(ch, s1Map.get(ch)+1);
        }

        while(i<=j && j<s2.length()){
            String subStr = s2.substring(i,j+1);
            for(int j1 = 0; j1<subStr.length(); j1++){
                char ch1 = subStr.charAt(j1);
                s2Map.put(ch1, s2Map.get(ch1)+1);
            }      
            if(s1Map.equals(s2Map)){
                return true;
            }
            for(int j2 = 0; j2<subStr.length(); j2++){
                char ch2 = subStr.charAt(j2);
                s2Map.put(ch2, 0);
            }  
            i++;
            j = i+len-1;
        }

        return false;
    }
}
Co
