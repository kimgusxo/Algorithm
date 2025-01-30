import java.util.*;

class Solution {
    public static int solution(String[][] book_time) {

        ArrayList<List<Integer>> times = new ArrayList<>();

        for(String[] time : book_time) {

            String startStr = time[0].replace(":", "");
            String endStr = time[1].replace(":", "");

            int start = Integer.parseInt(startStr);
            int end = Integer.parseInt(endStr);

            List<Integer> numTimes = Arrays.asList(start, end);
            times.add(numTimes);
        }

        Collections.sort(times, Comparator.comparing(l -> l.get(0)));

        // 퇴실하고 청소시간 10분 고려 안함
        // 또 59분에서 넘어가는 것 정수형으로 풀어서 예외발생
        int hotels = 0;

        while(times.size() > 0) {
            List<Integer> time = times.remove(0);
            calcTime(time);
            hotels++;

            // 중첩 for문에서 times.remove를 하면 뒤의 리스트가 땡겨와져서 for문 돌때 지장이 생김
            // 이부분 수정하면 정답일듯
            for(int j = 0; j < times.size(); j++) {
                if(time.get(1) <= times.get(j).get(0)) {
                    time = times.remove(j);
                    calcTime(time);
                    j--;
                }
            }

        }
        return hotels;
    }
    
    // 10분 고려와 60분이 넘어갔을때 시간 계산
    public static void calcTime(List<Integer> time) {
        int end = time.get(1);
        end += 10;
        
        if(end%100 >= 60) {
            end -= 60;
            end += 100;
        }
        
        time.set(1, end);
    }
}