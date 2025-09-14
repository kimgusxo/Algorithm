import java.util.*;

class Solution {
    static Map<Integer, Integer> map = Map.of(6,1,5,2,4,3,3,4,2,5); 
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        int hit = 0;
        
        for(int num : lottos) {
            if(num == 0) {
                zero++;
            } else {
                for(int win : win_nums) {
                    if(win == num) {
                        hit++;
                        break;
                    }
                }
            }
        }
        
        return new int[]{map.getOrDefault(hit+zero, 6), map.getOrDefault(hit, 6)};
    }
}