import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] str_list) {
        ArrayList<String> answer = new ArrayList<>();
        
        List<String> list = Arrays.stream(str_list).collect(Collectors.toList());
        int left = list.indexOf("l");
        int right = list.indexOf("r");
        if(right == -1 && left == -1) {
            return new String[]{};
        } else {
            if(left != -1 && ((left < right) || right == -1)) {
                for(int i = 0; i < left; i++) {
                    answer.add(str_list[i]);
                }
            } else if(right != -1 && ((left > right) || left == -1)) {
                for(int i = right+1; i < str_list.length; i++) {
                    answer.add(str_list[i]);
                }
            }
        }
        
        return answer.toArray(String[]::new);
    }
}