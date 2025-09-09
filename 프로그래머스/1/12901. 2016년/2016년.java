import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public String solution(int a, int b) {
        String[] answer = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
        
        LocalDate ld1 = LocalDate.of(2016, 1, 1);
        LocalDate ld2 = LocalDate.of(2016, a, b);
        
        int k = (int) ChronoUnit.DAYS.between(ld1, ld2);
        
        return answer[k%answer.length];
    }
}