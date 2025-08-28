class Solution {
    public String solution(int n) {
        String s = "수박".repeat(n%2==0 ? n/2 : n/2+1);
        return n%2 == 0 ? s : s.substring(0, s.length()-1);
    }
}