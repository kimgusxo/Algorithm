class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < arr1.length; i++) {
            String a1 = Integer.toBinaryString(arr1[i]);
            String a2 = Integer.toBinaryString(arr2[i]);
            
            String temp1 = "0".repeat(n-a1.length()) + a1;
            String temp2 = "0".repeat(n-a2.length()) + a2;
        
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < temp1.length(); j++) {
                if(temp1.charAt(j) == '1' || temp2.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}