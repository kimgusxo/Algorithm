class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        
        if(answer.length == 0) return new int[]{-1};
        
        int min = Integer.MAX_VALUE;
        int idx = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }
        
        int k = 0;
        for(int i = 0; i < answer.length; i++) {
            if(i == idx) {
                k++;
            } 
                
            answer[i] = arr[i+k];
        }
        
        return answer;
    }
}