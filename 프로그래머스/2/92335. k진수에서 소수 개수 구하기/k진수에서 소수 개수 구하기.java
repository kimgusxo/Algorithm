class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] tokens = Integer.toString(n, k).split("0");
        
        for(String t : tokens) {
            if(!t.equals("") && Long.parseLong(t) >= 2) {
                answer += isPrime(Long.parseLong(t)) ? 1 : 0;
            }
        }
        
        return answer;
    }
    
    public static boolean isPrime(long n) {
        for(int i = 2; i <= (int) Math.sqrt(n); i++) {
            if(n%i == 0) {
                 return false;
            }
        }
        
        return true;
    }
}