import java.util.*;

class Solution {
    
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();

        for(int i = 1; i < 27; i++) {
            dic.put(String.valueOf((char) (i+64)), i);
        }

        Deque<String> queue = new ArrayDeque<>(Arrays.asList(msg.split("")));

        int num = 27;
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            String next = queue.peek();

            sb.append(cur);

            if(!dic.containsKey(sb+next)) {
                dic.put(sb+next, num);
                answer.add(dic.get(sb.toString()));
                sb = new StringBuilder();
                num++;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}