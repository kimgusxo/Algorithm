class Solution {
    static int[] cntX = new int[10];
    static int[] cntY = new int[10];
    static int[] dup = new int[10];
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        for(char c : X.toCharArray()) {
            cntX[Character.getNumericValue(c)]++;
        }
        
        for(char c : Y.toCharArray()) {
            cntY[Character.getNumericValue(c)]++;
        }
        
        for(int i = 0; i < 10; i++) {
            dup[i] = Math.min(cntX[i], cntY[i]);
        }
        
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < dup[i]; j++) {
                if(i == 0 && answer.length() == 0) {
                    answer.append(i);
                    break;
                }
                answer.append(i);
            }
        }
        
        return answer.length() == 0 ? "-1" : answer.toString();
    }
}