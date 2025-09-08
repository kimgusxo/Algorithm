import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        for(String[] p : photo) {
            int point = 0 ;
            for(String n : p) {
                point += map.getOrDefault(n, 0);
            }
            answer[idx] = point;
            idx++;
        }
        
        return answer;
    }
}