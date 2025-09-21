import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayDate = Integer.parseInt(today.replace(".", ""));

        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }

        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] t = privacies[i].split(" ");
            String[] date = t[0].split("\\.");

            int carry = (Integer.parseInt(date[1])+map.get(t[1]));
            int cnt = 0;
            while(true) {
                if(carry < 13) break;
                carry -= 12;
                cnt++;
            }
            
            String month = carry >= 10 ? carry+"" : "0"+carry;
            String year = (Integer.parseInt(date[0])+cnt)+"";

            String calcDate = year+month+date[2];

            if(Integer.parseInt(calcDate) <= todayDate) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
}