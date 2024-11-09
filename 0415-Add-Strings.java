class Solution {
    public String addStrings(String num1, String num2) {

        //num1 = "11" //2 //l1
        //num2 = "123" //3 //l2
        //result =  "134"

        //l<-r

        int len = Math.max(num1.length(), num2.length());
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;

        String res = "";
        int carry = 0;
        while(len > 0){
            int n1 =  l1 < 0 ? 0 : num1.charAt(l1) - '0';
            int n2 = l2 < 0 ? 0 : num2.charAt(l2) - '0';
            int sum = n1 + n2 + carry;

            carry = sum/10;
            res+= sum%10;
            //10+2 = 12 12/10 = 1 carry 12%10 = 2, remainder
            //431
            len--;
            l1--;
            l2--;
        }

        if(carry > 0){
            res+=carry;
        }
        // System.out.println(res);

        //reverse a string
        String reverse = "";
        for(int j = res.length()-1 ; j >= 0; j--){
            reverse+=res.charAt(j);
        }

        // System.out.println(reverse);

        return reverse;
    }
}
