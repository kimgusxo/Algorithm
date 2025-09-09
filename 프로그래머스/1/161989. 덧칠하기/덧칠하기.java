class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int range = (section[0]+m)-1;
        for(int i = 0; i < section.length; i++) {
            if(range < section[i]) {
                range = (section[i]+m)-1;
                answer++;
            }
        }
        
        return answer;
    }
}