import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> answerMap = new HashMap<>();
        Map<String, String> recordsMap = new HashMap<>();
        
        for(String r : records) {
            String[] rc = r.split(" ");
            
            if(rc[2].equals("IN")) {
                recordsMap.put(rc[1], rc[0]);
            } else {
                String[] start = recordsMap.get(rc[1]).split(":");
                String[] end = rc[0].split(":");
                
                int startT = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
                int endT = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]);
                
                int time = endT - startT;
                
                answerMap.put(rc[1], answerMap.getOrDefault(rc[1], 0) + time);
                recordsMap.remove(rc[1]);
            }
        }
        
        int last = 23*60 + 59;
        for(String key : recordsMap.keySet()) {
            String[] start = recordsMap.get(key).split(":");
        
            int startT = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
            
            int time = last - startT;
        
            answerMap.put(key, answerMap.getOrDefault(key, 0) + time);
        }
        
        List<String> keySet = new ArrayList<>(answerMap.keySet());
        int[] answer = new int[keySet.size()];
        
        Collections.sort(keySet);
        for(int i = 0; i < answer.length; i++) {
            if(answerMap.get(keySet.get(i)) > fees[0]) {
                answer[i] = fees[1] + ((int) Math.ceil((double) (answerMap.get(keySet.get(i)) - fees[0]) / (double) fees[2]) * fees[3]); 
            } else {
                answer[i] = fees[1];
            }
        }
        
        return answer;
    }
}