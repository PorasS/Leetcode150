class Solution {

  List < String > list = null;
  List < String > res = null;
  Map < Integer, String > map = null;
  public List < String > letterCombinations(String digits) {

    if (digits == null || digits.length() == 0) {
      return new ArrayList < > ();
    }

    map = new HashMap < > ();
    map.put(2, "abc");
    map.put(3, "def");
    map.put(4, "ghi");
    map.put(5, "jkl");
    map.put(6, "mno");
    map.put(7, "pqrs");
    map.put(8, "tuv");
    map.put(9, "wxyz");

    res = new ArrayList < > ();

    bt(0, "", digits);

    return res;
  }

  public void bt(int idx, String charStr, String digits) {

    if (idx == digits.length()) {
      res.add(charStr);
      return;
    }

    String str = map.get(digits.charAt(idx) - '0');
    for (int i = 0; i < str.length(); i++) {
      bt(idx + 1, charStr + str.charAt(i), digits);
    }

    return;
  }
}
