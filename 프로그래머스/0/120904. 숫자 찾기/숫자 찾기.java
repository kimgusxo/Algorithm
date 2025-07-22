class Solution {
    public int solution(int num, int k) {
        String s = num + "";
        int answer = 1;
        for (char c : s.toCharArray()) {
            if (Character.getNumericValue(c) == k) {
                break;
            }
            answer++;
        }
        return answer == s.length()+1 ? -1 : answer;
    }
}