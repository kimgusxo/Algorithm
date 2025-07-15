class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        my_string.chars().forEach(x -> sb.append(String.valueOf((char) x).repeat(n)));
        return sb.toString();
    }
}