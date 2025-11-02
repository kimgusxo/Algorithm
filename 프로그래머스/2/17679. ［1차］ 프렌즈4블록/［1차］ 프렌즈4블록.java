import java.util.*;

class Solution {
    
    static int answer = 0;

    public int solution(int m, int n, String[] board) {

        List<List<String>> map = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = m-1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                map.get(j).add(String.valueOf(board[i].charAt(j)));
            }
        }

        while(true) {
            boolean[][] visited = new boolean[m][n];

            boolean flag = isRemove(map, visited);

            if(flag) {
                map = delete(map, visited);
            }

            if(!flag) break;
        }

        return answer;
    }

    public static boolean isRemove(List<List<String>> map, boolean[][] visited) {
        boolean flag = false;

        for(int i = 0; i < map.size()-1; i++) {
            for(int j = 0; j < map.get(i).size(); j++) {
                if(map.get(i).size() > j+1 && map.get(i+1).size() > j+1) {
                    String el = map.get(i).get(j);

                    if(el.equals(map.get(i+1).get(j+1)) &&
                            el.equals(map.get(i).get(j+1)) &&
                            el.equals(map.get(i+1).get(j))) {

                        visited[j][i] = true;
                        visited[j+1][i] = true;
                        visited[j][i+1] = true;
                        visited[j+1][i+1] = true;

                        flag = true;
                    }
                }
            }
        }

        return flag;
    }

    public static List<List<String>> delete(List<List<String>> map, boolean[][] visited) {
        for (int i = 0; i < map.size(); i++) {
            for (int j = map.get(i).size() - 1; j >= 0; j--) {
                if (j < visited.length && i < visited[0].length && visited[j][i]) {
                    map.get(i).remove(j);
                    answer++;
                }
            }
        }
        return map;
    }
}