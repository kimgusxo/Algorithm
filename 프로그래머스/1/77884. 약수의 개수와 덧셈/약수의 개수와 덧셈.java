class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(; left<=right; left++) {
            answer += divide(left) % 2 == 0 ? left : left*-1;
        }
        
        return answer;
    }
    
    public int divide(int num) {
        int cnt = 0;
        
        for(int i = 1; i <= num; i++) {
            if(num%i==0) {
               cnt++; 
            }
        }
        
        return cnt;
    }
}