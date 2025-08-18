class Solution {
    public String solution(String n_str) {
        int idx = 0;
        for(char c : n_str.toCharArray()) {
            if(c == '0') {
                idx++;
            } else {
                break;
            }
        }
        
        return n_str.substring(idx, n_str.length());
    }
}