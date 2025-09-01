class Solution {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;
        
        for(int[] el : sizes) {
            if(el[0] >= el[1]) {
                max1 = Math.max(el[0], max1);
                max2 = Math.max(el[1], max2);
            } else {
                max1 = Math.max(el[1], max1);
                max2 = Math.max(el[0], max2);
            }
        }
        
        return max1*max2;
    }
}