class Solution {
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder numbers = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i <= m*t; i++) {
            numbers.append(Integer.toString(i, n));
        }
        
        for(int i = 0; i < t; i++) {
            answer.append(numbers.charAt((m*i)+(p-1)));
        }
        
        return answer.toString().toUpperCase();
    }
}