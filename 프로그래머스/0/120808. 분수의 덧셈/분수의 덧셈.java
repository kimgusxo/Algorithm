class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int ansNum = (numer1*denom2) + (numer2*denom1);
        int ansDenom = denom1*denom2;
        
        int range = ansNum >= ansDenom ? ansDenom : ansNum;
        for(int i = range; i > 1; i--) {
            if(ansNum%i == 0 && ansDenom%i == 0) {
                ansNum /= i;
                ansDenom /= i;
                break;
            }
        }
        
        answer[0] = ansNum;
        answer[1] = ansDenom;
    
        return answer;
    }
}