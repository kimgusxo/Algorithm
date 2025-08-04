import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int start = -1;
        int end = -1;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                start = i;
            }
            if(arr[arr.length-1-i] == 2) {
                end = arr.length-1-i;
            }
        }
        
        return start != -1 ? Arrays.copyOfRange(arr, end, start+1) : new int[]{-1};
    }
}