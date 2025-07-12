import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    static ArrayList<Integer> temp = new ArrayList<>();
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        long range = 1;
        for(int i = 1; i <= n; i++) {
            range *= i;
        }

        for(int i = n; i > 0; i--) {
            range = range / i;
            int cnt = (int) ((k-1) / range);
            k = (k-1) % range+1;
            temp.add(list.remove(cnt));
        }

        for(int i = 0; i < n; i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}