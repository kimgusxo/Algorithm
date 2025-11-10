class Solution {
    
    public int[] solution(int[] sequence, int k) {
        int result = sequence[sequence.length-1];
        int left = sequence.length-1;
        int right = sequence.length-1;
        for(int i = sequence.length-2; i >= 0; i--) {
            if(result == k) break;
            
            if(result + sequence[i] <= k) {
                result += sequence[i];
                left = i;
            } else {
                result -= sequence[right];
                result += sequence[i];
                right--;
                left = i;
            }
            
        }
        
        while(right > 0 && left > 0) {
            if(sequence[right] == sequence[left-1]) {
                right--;
                left--;
            } else {
                break; 
            } 
        }
        
        return new int[]{left, right};
    }
}