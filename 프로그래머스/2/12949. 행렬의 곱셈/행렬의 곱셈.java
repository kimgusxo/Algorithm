class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0; i < arr1.length; i++) {
            for(int ii = 0; ii < arr2[0].length; ii++) {
                int val = 0;
                for(int iii = 0; iii < arr1[0].length; iii++) {
                    val += arr1[i][iii] * arr2[iii][ii];
                }
                answer[i][ii] = val;
            }
        }
        
        return answer;
    }
}