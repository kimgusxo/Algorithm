import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int person = 0;
        int turn = 0;

        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        char c = words[0].charAt(words[0].length()-1);
        for(int i = 1; i < words.length; i++) {
            String w = words[i];
            if(!set.contains(w) && w.charAt(0) == c) {
                set.add(w);
                c = w.charAt(w.length()-1);
            } else {
                person = i%n+1;
                turn = i/n + 1;
                break;
            }
        }
        
        return new int[]{person, turn};
    }
}