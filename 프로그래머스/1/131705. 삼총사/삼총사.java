import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        ArrayList<Integer> three = new ArrayList<>();
        recursive(number, visited, three, 0);
        return answer;
    }
    
    public static void recursive(int[] number, boolean[] visited,
                                 ArrayList<Integer> three, int idx) {
        for(int i = idx; i < number.length; i++) {
            if(three.size() == 3) {
                int sum = 0;
                for(int el : three) {
                    sum += el;
                }
                
                if(sum == 0) {
                    answer++;
                }
                return;
            } else if(!visited[i]) {
                visited[i] = true;
                three.add(number[i]);
                recursive(number, visited, three, i);
                three.remove(three.size()-1);
                visited[i] = false;
            }
        }
     }
}