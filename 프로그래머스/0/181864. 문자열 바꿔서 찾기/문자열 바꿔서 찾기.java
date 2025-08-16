class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : myString.toCharArray()) {
            if(c == 'A') {
                sb.append("B");
            } else {
                sb.append("A");
            }
        }
        
        return sb.toString().contains(pat) ? 1 : 0;
    }
}