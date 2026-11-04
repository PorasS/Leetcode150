class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> tmap = new HashMap<>();

        for (char c : t.toCharArray()) {
            if (!tmap.containsKey(c)) {
                tmap.put(c, 0);
            }

            tmap.put(c, tmap.get(c) + 1);
        }

        String res = "";
        int minLen = (int) 1e9;

        int l = 0;
        int r = 0;
        int count = 0;
        while (r < s.length()) {

            char ch = s.charAt(r);

            if (tmap.containsKey(ch)) {
                if (tmap.get(ch) > 0) {
                    count += 1;
                }

                tmap.put(ch, tmap.get(ch) - 1);

                while (count == t.length()) {
                    //trimming
                    String substr = s.substring(l, r + 1);
                    if (substr.length() < minLen) {
                        res = substr;
                        minLen = res.length();
                    }

                    if (tmap.containsKey(s.charAt(l))) {

                        tmap.put(s.charAt(l), tmap.get(s.charAt(l)) + 1);

                        if (tmap.get(s.charAt(l)) > 0) {
                            count -= 1;
                        }

                        l++;
                    } else {
                        l++;
                    }
                }
                r++;

            } else {
                r++;
            }

        }

        return res;
    }

}
