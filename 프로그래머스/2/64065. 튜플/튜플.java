import java.util.*;

class Solution {
    
    // 일단 replace를 통해 괄호 없애고 split(",") 한 뒤 숫자원소 넣기
    // 맵만들고 <값, 빈도수>로 넣기
    // 맵을 밸류값으로 정렬 후 리스트에 넣기
    // 리스트 배열화
    
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        
        String[] numbers = s.replace("{", "").replace("}", "").split(",");
        for(String num : numbers) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)));
        
        return keySet.stream().mapToInt(x -> Integer.parseInt(x)).toArray();
    }
}