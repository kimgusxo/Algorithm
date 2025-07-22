class Solution {
    public int solution(int a, int b) {
        int left = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        int right = 2*a*b;
        return left >= right ? left : right;
    }
}