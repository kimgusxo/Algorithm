class Solution {
    public int solution(int num1, int num2) {
        int answer = (int) Math.floor((double) num1 / (double) num2 * 1000.0);
        return answer;
    }
}