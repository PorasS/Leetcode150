class Solution {

  public String longestPalindrome(String s) {

    String res = "";

    boolean isEven = s.length() % 2 == 0;

    for (int i = 0; i < s.length(); i++) {

      int l = 0;
      int r = 0;

      //even
      l = i;
      r = i + 1;

      while (l >= 0 && r < s.length()) {
        if (s.charAt(l) == s.charAt(r)) {
          String str = s.substring(l, r + 1);
          res = str.length() > res.length() ? str : res;
          l--;
          r++;
        } else {
          break;
        }
      }

      //odd
      l = i;
      r = i;

      while (l >= 0 && r < s.length()) {
        if (s.charAt(l) == s.charAt(r)) {
          String str = s.substring(l, r + 1);
          res = str.length() > res.length() ? str : res;
          l--;
          r++;
        } else {
          break;
        }
      }
    }

    return res;
  }
}
