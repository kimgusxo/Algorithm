import java.util.*;

class Solution {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (d1, d2) -> {
           if(d1[col-1] == d2[col-1]) {
               return Integer.compare(d2[0], d1[0]);
           } else {
               return Integer.compare(d1[col-1], d2[col-1]);
           }
        });
        
        
        boolean first = true;
        int answer = 0;
        for(int i = row_begin; i <= row_end; i++) {
            int d = 0;
            for(int j = 0; j < data[0].length; j++) {
                d += data[i-1][j]%i;
            }
            
            if(!first) {
                answer = d;
                first = false;
            } else {
                answer = answer ^ d; 
            }
        }
        
        return answer;
    }
}