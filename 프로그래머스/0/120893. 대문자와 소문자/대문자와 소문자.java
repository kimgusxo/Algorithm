class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++) {
            if('A' <= my_string.charAt(i) && my_string.charAt(i) <= 'Z') {
                sb.append(my_string.toLowerCase().charAt(i));
            } else {
                sb.append(my_string.toUpperCase().charAt(i));
            }
        }
        return sb.toString();
    }
}