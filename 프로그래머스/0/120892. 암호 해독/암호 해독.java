class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(idx*code-1 < cipher.length()) {
            sb.append(cipher.charAt(idx*code-1));
            idx++;
        }
        return sb.toString();
    }
}