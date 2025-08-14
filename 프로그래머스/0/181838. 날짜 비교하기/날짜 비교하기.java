class Solution {
    public int solution(int[] date1, int[] date2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        return Integer.parseInt(sb1.append(date1[0]).append(date1[1]).append(date1[2]).toString()) < Integer.parseInt(sb2.append(date2[0]).append(date2[1]).append(date2[2]).toString()) ? 1 : 0;
    }
}