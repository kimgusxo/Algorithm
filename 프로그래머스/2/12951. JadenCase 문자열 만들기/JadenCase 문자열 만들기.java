class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(first) {
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
            } else {
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
            
            if(s.charAt(i) == ' ') {
                first = true;
            } else {
                first = false;
            }
        }
        
        return sb.toString();
    }
}