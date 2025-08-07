import java.util.Arrays;

class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for(int i = 0; i <= a.length; i++) {
            char[] move = new char[a.length];
            for(int j = 0; j < a.length; j++) {
                move[(i + j)%a.length] = a[j];
            }
            if(Arrays.equals(move, b)) {
                answer = i;
                break;
            } 
        }
        
        return answer;
    }
}