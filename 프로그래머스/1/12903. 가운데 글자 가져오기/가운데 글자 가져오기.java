class Solution {
    public String solution(String s) {
        int lth = s.length();
        return lth % 2 == 0 ? s.substring(lth/2-1, lth/2+1) : String.valueOf(s.charAt(lth/2));
    }
}