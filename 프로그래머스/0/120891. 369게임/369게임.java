class Solution {
    public int solution(int order) {
                return (int) String.valueOf(order).chars().filter(x -> x == '3' || x == '6' || x == '9').count();
    }
}