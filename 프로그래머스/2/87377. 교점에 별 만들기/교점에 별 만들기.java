import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(int[][] line) {
        ArrayList<long[]> arr = new ArrayList<>();
        
        long xMin = Long.MAX_VALUE;
        long yMin = Long.MAX_VALUE;
        long xMax = Long.MIN_VALUE;
        long yMax = Long.MIN_VALUE;

        for(int i = 0; i < line.length; i++) {
            for(int ii = i+1; ii < line.length; ii++) {
                long A = line[i][0];
                long B = line[i][1];
                long C = line[ii][0];
                long D = line[ii][1];
                long E = line[i][2];
                long F = line[ii][2];
                
                long BF = B*F;
                long ED = E*D;
                long EC = E*C;
                long AF = A*F;
                long AD = A*D;
                long BC = B*C;

                if(AD-BC == 0) continue;

                if((BF-ED) % (AD-BC) != 0 || (EC-AF) % (AD-BC) != 0) continue;
                
                long x = (BF-ED) / (AD-BC);
                long y = (EC-AF) / (AD-BC);

                xMin = Math.min(xMin, x);
                xMax = Math.max(xMax, x);
                yMin = Math.min(yMin, y);
                yMax = Math.max(yMax, y);

                arr.add(new long[]{x, y});
            }
        }
        int row = (int) (yMax-yMin+1);
        int col = (int) (xMax-xMin+1);
        
        String[][] box = new String[row][col];

        for(int i = 0; i < box.length; i++) {
            for(int ii = 0; ii < box[0].length; ii++) {
                box[i][ii] = ".";
            }
        }

        for(long[] pos : arr) {
            box[(int) (pos[1]-yMin)][(int) (pos[0]-xMin)] = "*";
        }

        String[] answer = new String[box.length];

        for(int i = 0; i < box.length; i++) {
            answer[i] = String.join("", box[box.length-1-i]);
        }

        return answer;
    }
}


