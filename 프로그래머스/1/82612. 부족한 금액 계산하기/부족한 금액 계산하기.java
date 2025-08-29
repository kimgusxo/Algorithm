class Solution {
    public long solution(int price, int money, int count) {
        int total = 0;
        
        for(int i = 1; i <= count; i++) total += i;
        
        long answer = ((long) price*total)-money;
        return answer >= 0 ? answer : 0;
    }
}