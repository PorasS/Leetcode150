class Solution {
    public boolean isPalindrome(String s) {
		    
        String str = "";
        for(int i = 0; i <s.length(); i++){
            if((s.charAt(i)>=97 && s.charAt(i)<=122) || (s.charAt(i)>=48 && s.charAt(i)<=57)){//ascii range for a-z and 0-9
                str=str+s.charAt(i);
            }
            if(s.charAt(i)>=65 && s.charAt(i)<=90){//ascii range for A-Z
                str=str+Character.toLowerCase(s.charAt(i));
            }
        }
                
        if(str.isEmpty() || str.length()==1){
            return true;
        }
        
        int i = 0;
        int j = 0;
        if(str.length()%2==0){//even length string
            j = str.length()/2;
            i = (str.length()/2)-1;
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i=i-1;
            j=j+1;
            while(i>=0 && j<str.length()){
                if(str.charAt(i)==str.charAt(j)){
                    i=i-1;
                    j=j+1;
                }else{
                    return false;
                }
            }
        }else{//odd length string
        i = (str.length()/2)-1;
        j = (str.length()/2)+1;
        while(i>=0 && j<str.length()){
            if(str.charAt(i)==str.charAt(j)){
                    i=i-1;
                    j=j+1;
            }else{
                return false;
            }
        }

    }
    return true; 
    }
}
