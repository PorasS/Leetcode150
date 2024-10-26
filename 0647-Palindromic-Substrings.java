class Solution {

  public int countSubstrings(String s) {

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      //even
      int l = i;
      int r = i + 1;

      boolean isPalindrome = false;
      while (l >= 0 && r < s.length()) {
        if (s.charAt(l) == s.charAt(r)) {
          count++;
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
          count++;
          l--;
          r++;
        } else {
          break;
        }
      }
    }

    return count;
  }
}
