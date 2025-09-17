import java.util.*;

class Solution {
    
    static Map<String, Integer> table = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        
        int selectIdx = table.get(ext);
        for(int[] d : data) {
            if(d[selectIdx] < val_ext) {
                list.add(d);
            }
        }
        
        int sortIdx = table.get(sort_by);
        list.sort((o1, o2) -> {
            return o1[sortIdx] - o2[sortIdx];
        });
        
        int[][] answer = new int[list.size()][4];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}