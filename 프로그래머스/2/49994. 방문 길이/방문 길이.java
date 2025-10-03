import java.util.*;

class Solution {
    
    static Set<String> answer = new HashSet<>();
    
    static int curX = 0;
    static int curY = 0;
    
    public int solution(String dirs) {
        for(String d : dirs.split("")) {
            move(d);
        }
        
        return answer.size()/2;
    }

    public static void move(String d) {
        int dx = 0;
        int dy = 0;
        
        switch(d) {
            case "U":
                dx = 1;        
                break;
            case "D":
                dx = -1;
                break;
            case "R":
                dy = 1;
                break;
            case "L":
                dy = -1;
                break;
        }
        
        int nx = curX + dx;
        int ny = curY + dy;
        
        if((-5 <= nx && nx <= 5) && (-5 <= ny && ny <= 5)) {
            StringBuilder forward = new StringBuilder();
            forward.append(curX).append(curY).append(nx).append(ny);
            
            StringBuilder reverse = new StringBuilder();
            reverse.append(nx).append(ny).append(curX).append(curY);
            
            if(!answer.contains(forward.toString())) {
                answer.add(forward.toString());
                answer.add(reverse.toString());
            }
            
            curX = nx;
            curY = ny;
        }
    }
}