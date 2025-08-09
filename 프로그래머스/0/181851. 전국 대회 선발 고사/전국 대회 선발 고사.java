import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < rank.length; i++) {
            if(attendance[i]) treeMap.put(rank[i], i);
        }
        
        int[] arr = treeMap.values().stream().mapToInt(x -> x).toArray();
        
        return arr[0]*10000 + arr[1]*100 + arr[2];
    }
}