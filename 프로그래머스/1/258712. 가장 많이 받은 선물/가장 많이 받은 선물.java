import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Map<String, Integer>> gMap = new HashMap<>();
        Map<String, Integer> pMap = new HashMap<>();

        for(String friend : friends) {
            gMap.put(friend, new HashMap<>());
            pMap.put(friend, 0);
        }

        for(String gift : gifts) {
            String[] g = gift.split(" ");

            Map<String, Integer> map = gMap.getOrDefault(g[0], new HashMap<>());
            map.put(g[1], map.getOrDefault(g[1], 0)+1);
            gMap.put(g[0], map);

            pMap.put(g[0], pMap.get(g[0])+1);
            pMap.put(g[1], pMap.get(g[1])-1);
        }

        for(String key1 : gMap.keySet()) {
            int cnt = 0;
            for(String key2 : friends) {
                if(gMap.get(key1).getOrDefault(key2, 0) > gMap.get(key2).getOrDefault(key1, 0)) {
                    cnt++;
                } else if(gMap.get(key1).getOrDefault(key2, 0) == gMap.get(key2).getOrDefault(key1, 0)) {
                    if(pMap.get(key1) > pMap.get(key2)) {
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}