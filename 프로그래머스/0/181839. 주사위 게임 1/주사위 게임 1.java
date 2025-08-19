class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        if(a % 2 == 0 && b % 2 == 0) {
            answer = (int) Math.abs(a-b);
        } else if(a % 2 == 0 || b % 2 == 0) {
            answer = 2*(a+b);
        } else {
            answer = (int) (Math.pow(a, 2) + Math.pow(b, 2));
        }
        
        return answer;
    }
}