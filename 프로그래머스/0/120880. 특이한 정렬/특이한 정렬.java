import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numlist.length; i++) {
            map.put(i, numlist[i]-n);
        }

        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet, (o1, o2) -> {
            if(Math.abs(map.get(o1)) == Math.abs(map.get(o2))) {
                if(map.get(o1) > map.get(o2)) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return Math.abs(map.get(o1)) - Math.abs(map.get(o2));
            }
        });

        int idx = 0;
        for(int el : keySet) {
            answer[idx] = numlist[el];
            idx++;
        }

        return answer;
    }
}