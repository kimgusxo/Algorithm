import java.util.*;

class Solution {
    
    static Map<Integer, int[]> map = Map.of(1, new int[]{0, 0},
                                           2, new int[]{0, 1},
                                           3, new int[]{0, 2},
                                           4, new int[]{1, 0},
                                           5, new int[]{1, 1},
                                           6, new int[]{1, 2},
                                           7, new int[]{2, 0},
                                           8, new int[]{2, 1},
                                           9, new int[]{2, 2},
                                           0, new int[]{3, 1});
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int leftX = 0;
        int leftY = 3;
        int rightX = 2;
        int rightY = 3;
        
        for(int num : numbers) {
            switch(num) {
                case 1, 4, 7:
                    leftY = map.get(num)[0];
                    leftX = map.get(num)[1];
                    answer.append("L");
                    break;
                case 3, 6, 9:
                    rightY = map.get(num)[0];
                    rightX = map.get(num)[1];
                    answer.append("R");
                    break;
                default:
                    int distL = Math.abs(map.get(num)[0]-leftY) + Math.abs(map.get(num)[1]-leftX);
                    int distR = Math.abs(map.get(num)[0]-rightY) + Math.abs(map.get(num)[1]-rightX);
                    
                    if(distL > distR) {
                        rightY = map.get(num)[0];
                        rightX = map.get(num)[1];
                        answer.append("R");
                    } else if(distL < distR) {
                        leftY = map.get(num)[0];
                        leftX = map.get(num)[1];
                        answer.append("L");
                    } else {
                        if(hand.equals("left")) {
                            leftY = map.get(num)[0];
                            leftX = map.get(num)[1];
                            answer.append("L");
                        } else {
                            rightY = map.get(num)[0];
                            rightX = map.get(num)[1];
                            answer.append("R");
                        }
                    }
                    break;
            }
        }
        
        return answer.toString();
    }
}