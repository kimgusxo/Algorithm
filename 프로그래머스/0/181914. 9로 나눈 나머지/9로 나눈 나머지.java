class Solution {
    public int solution(String number) {
        return (number.chars().map(i -> (i-'0')).sum()) % 9;
    }
}