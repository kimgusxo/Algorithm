import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(Integer n : numbers) {
            list.add(String.valueOf(n));
        }
        
        list.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        StringBuilder sb = new StringBuilder();
        for(String el : list) {
            sb.append(el);
        }
        
        if (list.get(0).equals("0")) return "0";
        
        return sb.toString(); 
    }
}