import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> declarationMap = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        for(String id : id_list) {
            declarationMap.put(id, 0);
            reportMap.put(id, new HashSet<>());
        }
        
        for(String rp : report) {
            String reporter = rp.split(" ")[0];
            String reported = rp.split(" ")[1];
        
            Set<String> set = reportMap.get(reporter);
            
            int size = set.size();
            
            set.add(reported);
            reportMap.put(reporter, set);
            
            if(set.size() != size) {
                declarationMap.put(reported, declarationMap.get(reported)+1);
            }
        }
        
        int idx = 0;
        for(String id : id_list) {
            Set<String> set = reportMap.get(id);
            for(String el : set) {
                if(declarationMap.get(el) >= k) {
                    answer[idx]++;
                }
            }
            idx++;
        }
        
        return answer;
    }
}