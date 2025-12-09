import java.util.*;

class Solution {

    static Map<String, Integer> optionMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        combo(orders, course);

        for(int c : course) {
            int max = 0;
            for(String key : optionMap.keySet()) {
                if(key.length() == c) {
                    max = Math.max(optionMap.get(key), max);
                }
            }

            for(String key : optionMap.keySet()) {
                if(optionMap.get(key) == max && key.length() == c) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    private static void combo(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++) {
            for(int j = i+1; j < orders.length; j++) {

                StringBuilder subOption = new StringBuilder();
                for(String order : orders[j].split("")) {
                    if(orders[i].contains(order)) {
                        subOption.append(order);
                    }
                }

                for(int c : course) {
                    boolean[] visited = new boolean[subOption.length()];
                    backtracking(c, subOption, visited, new StringBuilder(), 0);
                }
            }
        }
    }

    private static void backtracking(int length, StringBuilder subOption, boolean[] visited, StringBuilder op, int start) {
        if(op.length() == length) {
            char[] arr = op.toString().toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            optionMap.put(key, optionMap.getOrDefault(key, 0)+1);
        }

        for(int i = start; i < subOption.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                op.append(subOption.charAt(i));
                backtracking(length, subOption, visited, op, i+1);
                op.deleteCharAt(op.length()-1);
                visited[i] = false;
            }
        }
    }
}