class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        for(char c : String.valueOf(age).toCharArray()) {
            sb.append((char) (c-'0'+'a'));
        }
        return sb.toString();
    }
}