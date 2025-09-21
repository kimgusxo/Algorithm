class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int deadline = (schedules[i]+10)%100 >= 60 ? schedules[i]+50 : schedules[i]+10;
            
            int idx = 0;
            boolean eventFlag = true;
            for(int timelog : timelogs[i]) {
                if((startday+idx)%7 != 6 && (startday+idx)%7 != 0) {
                    if(timelog > deadline) {
                        eventFlag = false;
                    }   
                }
                idx++;
            }
            
            if(eventFlag) answer++;
        }
        
        return answer;
    }
}