import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> list = new ArrayList<>();
        int k = 0;
        while(k+n < my_str.length()) {
            list.add(my_str.substring(k, k+n));
            k += n;
        }
        list.add(my_str.substring(k, my_str.length()));
        return list.toArray(String[]::new);
    }
}