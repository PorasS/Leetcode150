public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here

        String str = "";
        for(String s : strs){
            str += Integer.toString(s.length())+"#"+s;
        }

        // System.out.println(str);

        return str;
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here

        List<String> strList = new ArrayList<>();
        //4#lint4#code4#love3#you

        int i = 0;
        int j = 0;

        while(i<str.length() && j<str.length()){
            try{
                if(str.charAt(j)!='#'){
                j+=1;
            }else{
                int length = Integer.parseInt(str.substring(i,j));
                int start = j+1;
                int end = start + length;
                strList.add(str.substring(start, end));
                j = end;
                i = end;
            }
            }catch(Exception e){

            }
        }
        return strList;
    }
}
