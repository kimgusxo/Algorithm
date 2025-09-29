import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> wantList = Arrays.asList(want);
        
        int idx = 0;
        String[] sortedWant = new String[10];
        for(int i = 0; i < want.length; i++) {
            for(int j = 0; j < number[i]; j++) {
                sortedWant[idx] = want[i];
                idx++;
            }
        }
        
        Arrays.sort(sortedWant);
        
        for(int i = 0; i <= discount.length-10; i++) {
            if(wantList.contains(discount[i])) {
                String[] temp = Arrays.copyOfRange(discount, i, i+10);
                Arrays.sort(temp);
                if(Arrays.equals(sortedWant, temp)) {
                    answer++;
                }
            }
            idx++;
        }
        
        return answer;
    }
}