class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        my_string.chars().forEach(c -> {
            if((char) c != 'a' && (char) c != 'e' && (char) c != 'i' && (char) c != 'o' && (char) c != 'u') {
                sb.append((char) c);
            }
        });
        return sb.toString();
    }
}