import java.util.*;

class Solution {
    
    static Map<Character, Integer> map = new HashMap<>(Map.of('R', 0, 
                                               'T', 0, 
                                               'C', 0, 
                                               'F', 0, 
                                               'J', 0, 
                                               'M', 0, 
                                               'A', 0,
                                               'N', 0));
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        for(int i = 0; i < choices.length; i++) {
            if(choices[i] < 4) {
                map.put(survey[i].charAt(0), (map.get(survey[i].charAt(0))+(4-choices[i])));
            } else if(choices[i] > 4) {
                map.put(survey[i].charAt(1), (map.get(survey[i].charAt(1))+(choices[i]-4)));
            }
        }
        
        return calc(answer);
    }
    
    public static String calc(String answer) {
        if(map.get('R') >= map.get('T')) {
            answer += "R";
        } else {
            answer += "T";
        }
        
        if(map.get('C') >= map.get('F')) {
            answer += "C";
        } else {
            answer += "F";
        }
        
        if(map.get('J') >= map.get('M')) {
            answer += "J";
        } else {
            answer += "M";
        }
        
        if(map.get('A') >= map.get('N')) {
            answer += "A";
        } else {
            answer += "N";
        }
        
        return answer;
    }
}