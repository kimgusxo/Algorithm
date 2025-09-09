import java.util.*;

class Solution {
    
    static int[] one = {1, 2, 3, 4, 5};
    static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int o1 = 0;
        int o2 = 0;
        int o3 = 0;
        
        for(int i = 0; i < answers.length; i++) {    
            if(one[i%one.length] == answers[i]) o1++;
            if(two[i%two.length] == answers[i]) o2++;
            if(three[i%three.length] == answers[i]) o3++;
        }
        
        int max = Math.max(Math.max(o1,o2),o3);
        
        if(max == o1) answer.add(1);
        if(max == o2) answer.add(2);
        if(max == o3) answer.add(3);
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}