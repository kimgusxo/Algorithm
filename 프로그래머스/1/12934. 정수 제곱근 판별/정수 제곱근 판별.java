class Solution {
    public long solution(long n) {
        double answer1 = Math.sqrt(n);
        double answer2 = Math.ceil(answer1);
        
        return answer1 >= answer2 ? (long) Math.pow(answer2+1, 2) : -1;
    }
}