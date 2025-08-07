class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int mid = total/num;
        int start = (int) Math.ceil((double) num/2)-1;
        int el = mid-start;
        for(int i = 0; i < num; i++) {
            answer[i] = el++;
        }
        
        return answer;
    }
}