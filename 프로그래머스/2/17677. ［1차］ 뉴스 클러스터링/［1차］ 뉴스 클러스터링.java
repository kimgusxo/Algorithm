import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        int max = 0;
        int min = 0;

        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();

        Map<String, Integer> s1Map = new HashMap<>();
        Map<String, Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length()-1; i++) {
            String el = s1.substring(i, i+2);
            if(el.matches("[a-zA-Z]+")) {
                s1Map.put(el, s1Map.getOrDefault(el, 0)+1);
                max++;
            }
        }

        for(int i = 0; i < s2.length()-1; i++) {
            String el = s2.substring(i, i+2);
            if(el.matches("[a-zA-Z]+")) {
                s2Map.put(el, s2Map.getOrDefault(el, 0)+1);
                max++;
            }
        }

        for(String key : s1Map.keySet()) {
            if(s1Map.containsKey(key) && s2Map.containsKey(key)) {
                min += Math.min(s1Map.get(key), s2Map.get(key));
            }
        }

        max -= min;
        double answer = 0;
        if(max == 0) {
            answer = 1.0;
        } else {
            answer = (double) min / max;
        }


        return (int) Math.floor(answer*65536);
    }
}